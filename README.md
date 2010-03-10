# meow

A scala [growl](http://growl.info/) client that purs

## play with kittens

    import meow._
    Growl title("Rowr") message("grrrr") image("/path/to/lion.png") meow

## play with the neighbor's kittens

    import meow._
    Growl title("Rowr") message("grrrr") udp() host(ip) password("shhh") meow

## install

Meow is [cross built](http://code.google.com/p/simple-build-tool/wiki/CrossBuild) over the following verions versions of scala.

    2.7.3, 2.7.4, 2.7.5, 2.7.6, 2.7.7
    
### via sbt

To include meow in your [sbt](http://code.google.com/p/simple-build-tool) project, add the following to your project file.

    class YourProject(info: ProjectInfo) extends PluginProject(info) {
      val lessRepo = "lessis repo" at "http://repo.lessis.me"
      val meow = "me.lessis" %% "meow" % "0.0.2"
    }
    
## todo
  
  * ~/.meow config file with defaults and network info

2010 Doug Tangren (softprops)