# meow

A scala [growl](http://growl.info/) client that purs

# play with kittens

    import meow._
    
    Growl title("Rowr") message("grrrr") image("/path/to/lion.png") meow

# play with neighbor's kittens

    import meow._
    
    Growl title("Rowr") message("grrrr") udp() host(ip) password("shhh") meow

# todo

  - ~/.meow config file with defaults and network info

2010 Doug Tangren (softprops)