package meow

import org.specs._

object GrowlSpec extends Specification {
  "Growl" should {
    "find a binary" in {
      Growl.bin must_== "/usr/local/bin/growlnotify"
    }
    "make sticky notifications" in  {
      (Growl sticky() argList) must contain("-s")
    }
    "show notifications with a message" in  {
      val g = Growl message("foo")
      (g argList) must contain("-m")
      (g argList) must contain("foo")
    }
    "show notifications with a title" in  {
      val g = Growl title("foo")
      (g argList) must contain("-t")
      (g argList) must contain("foo")
    }
  }
}