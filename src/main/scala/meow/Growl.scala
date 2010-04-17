package meow

import scala.io.Source

/** A Process Builder factory. in ~future~ @see @experimental scala.io.Process
 */
object > { def apply(s:String*) = new java.lang.ProcessBuilder(s.toArray:_*) }

/** Growl companion object */
object Growl extends Notifier(Map()) {
  import Transitioning._
  
  private val which = >("which", "growlnotify").start
  
  /** Path to growl executable 
   * @note getLines compiles < 2.8 but does not in > 2.8 and visa versa
   */
  val bin = Source.fromInputStream(which getInputStream).lines.mkString("").trim
  
  /** Indicates whether Growl is installed */
  val installed = bin.length != 0
  
  /** Warns client if Growl is not installed */
  def warn() = Console.err.println("growlnotify binary is not installed")
  if(!installed) warn()
}

/** Wrapper around the Growl cmd line binary */
private [meow] class Notifier(val args: Map[String, Any]) {
  private def arg(k:String)(v:Any) = new Notifier(args + (k->v))

  def argList = args.flatMap { case (k,v) => "-" + k :: v.toString :: Nil }.toList

  /** meow at something */
  def meow =
    Growl.installed match {
       case true => {
         > ((Growl.bin :: argList): _*) start
      }
      case _ => Growl.warn()
    }
  
  /**  Sets the message to be used */
  val message = arg("m")_
  
  /** Sets the title to be used */
  val title = arg("t")_
  
  /** Make the notification sticky */
  def sticky() = arg("s")("")
  
  /** Set the name of the application that sends the notification */
  val name = arg("n")_
  
  /** Specify an application name to take the icon from */
  val appIcon = arg("a")_
  
  /** Specify a file type or extension to look up for the notification icon */
  val iconType = arg("i")_
  
  /** Specify a file whose icon will be the notification icon */
  val iconPath = arg("I")_
  
  /** Specify an image file to be used for the notification icon */
  val image = arg("-image")_
  
  /** Priority can be one of the following named keys: 
   *  Very Low, Moderate, Normal,High, Emergency or an int between -2 and 2
   */
  val priority = arg("p")_
  
  /** Specify a notification identifier (used for coalescing) */
  val identifier = arg("d")_
  
  /** Specify a hostname to which to send a remote notification */ 
  val host = arg("H")_
  
  /** Password used for remote notifications */
  val password = arg("P")_
  
  /** Use UDP instead of DO to send a remote notification */
  def udp() = arg("u")("")
  
  /** Port number for UDP notifications */
  val port = arg("-port")_
  
  /** Specify digest algorithm for UDP authentication 
   * Either MD5 [Default], SHA256 or NONE.
   */
  val auth = arg("A")_
  
  /** Encrypt UDP notifications */
  val crypt = arg("c")_
}