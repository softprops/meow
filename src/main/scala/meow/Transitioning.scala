package meow

object Transitioning {
  import scala.io.Source
  class TransitionalSource(src: Source) {
    /** Source#getLines compiles < 2.8 but does not in > 2.8 and visa versa
      * due to new default args in 2.8 impl */
    def lines = src.toList.filter(!_.toString.equals(compat.Platform.EOL))
  }
  implicit def src2transitionalSrc(src: Source) = new TransitionalSource(src)
}