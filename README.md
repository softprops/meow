# meow

A Scala [growl](http://growl.info/) client that purrrrs

## play with kittens

    import meow._
    Growl title("Rowr") message("grrrr") image("/path/to/lion.png") meow

## play with the neighbor's kittens

    import meow._
    Growl title("Rowr") message("grrrr") udp() host(ip) password("shhh") meow

## install

    resolvers += "less is" at "http://repo.lessis.me"

    libraryDependencies += "me.lessis" %% "meow" % "0.1.1"

2010-2011 Doug Tangren (softprops)
