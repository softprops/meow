package meow

object Transitioning {
  import scala.io.Source
  class TransitionalSource(src: Source) {
    /** LineIterator is shim incompatible verions Source#getLines in Scala > 2.8 and < 2.8 */
    class LineIterator(iter: BufferedIterator[Char], separator: String) extends Iterator[String] {
      require(separator.length < 3, "Line separator may be 1 or 2 characters only.")

      private[this] val isNewline: Char => Boolean =
        separator.length match {
          case 1 => _ == separator(0)
          case 2 => {
            _ == separator(0) && iter.hasNext && {
              val res = iter.head == separator(1) // peek ahead
              if (res) { iter.next } // incr iter
              res
            }
          }
        }

      private[this] val builder = new StringBuilder

      private def buildingLine() = iter.next match {
        case nl if(isNewline(nl)) => false
        case ch =>  { 
          builder append ch
          true
        }
      }

      def hasNext = iter.hasNext
      def next = {
        builder.clear
        while (hasNext && buildingLine()) {}
        builder.toString
      }
    }
    /** Source#getLines compiles < 2.8 but does not in > 2.8 and visa versa
      * due to new default args in 2.8 impl */
    def lines = new LineIterator(src.buffered, compat.Platform.EOL)
  }
  implicit def src2transitionalSrc(src: Source) = new TransitionalSource(src)
}