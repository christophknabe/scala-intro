# The Play Framework
[Play](https://www.playframework.com/), or if you want to be unique, 
the **Play Framework** is the web framework by [Lightbend](https://www.lightbend.com/), the company maintaining the Scala compiler.

Features:
* Fully **asynchronous** web framework. By that it scales much better than **threaded** web frameworks like Java EE 7 or Spring 4 MVC. Enables **Reactive Programming**.
* Serves web pages as well as REST responses. 
* Written in Scala, APIs in Scala and Java
* Typesafe, powerful language like Scala
* Short developer cycle by SBT hot reload
* Well documented
* Maybe mainstream in Scala Web Development
* Competitors in the Scala world are [Lift](https://liftweb.net/) and [http4s](https://http4s.org/).


We will study the Baeldung tutorial [Building a REST API in Scala with Play Framework](https://www.baeldung.com/scala/play-rest-api).

## JDK Compatibility
This Baeldung tutorial is configured for Scala 2.13.12.
According to [Scala JDK COMPATIBILITY](https://docs.scala-lang.org/overviews/jdk-compatibility/overview.html#jdk-11-compatibility-notes) this should run on the LTS JDK versions 8, and 11.
As about 11 some caveats are mentioned, I would recommend to run the examples on a JDK 8. This avoids problems with the Java Module System from JDK 9 on.

## Import into IntelliJ IDEA

* Make sure you have a JDK 8 installed on your computer at *path/to/JDK8*.

* Clone the [Scala Tutorials from GitHub](https://github.com/Baeldung/scala-tutorials):
  `git clone git@github.com:Baeldung/scala-tutorials.git`
* A directory `scala-tutorials`will be created, which among others contains the directory `play-scala/rest-api`.
* In IntelliJ IDEA open the contained file `build.sbt` and select button `Open as Project`.
* Assure usage of JDK 8 by *File > Settings ... > Build, Execution, Deployment > Build Tools > sbt*:
  There under *JVM > JRE*: select an installed Java 8 JDK (8.0.322-Temurin in my case).
* On the project node by *MouseRight* select *Run > ScalaTests in 'rest-api'*. If the test run fails, look into its log window, by which Java version it was run. For correcting the test run Java version, select *Edit Configurations ... > ScalaTests in 'rest-api' > JRE:* 8.0.322-Temurin (or any JDK 8).
* In order to run the product, in IDEA click *sbt shell*, wait until the prompt `[rest-api] $ >` appears.
* Type `+run` &rArr; (Running the application, auto-reloading is enabled), AkkaHttpServer - Listening for HTTP on /0:0:0:0:0:0:0:0:9000
  You may stop the HTTP server by typing the key `<ENTER>`.
* Browse to http://localhost:9000/ 
  You will get an error page mentioning all the routes tried out unsuccessfully. This reveals that all endpoints of this REST server are under http://localhost:9000/todo.
* Browse to http://localhost:9000/todo &rArr; Returns a JSON Array with two TODO items:
  `[{"id":1,"description":"test","isItDone":true},{"id":2,"description":"some other value","isItDone":false}]`
* Now we follow the Baeldung tutorial from section [3.1 Create a Controller](https://www.baeldung.com/scala/play-rest-api#1-create-a-controller)
  and study each step in the source code.

## REST Project with Database
[Play Scala Slick Example](https://github.com/playframework/play-samples/tree/2.8.x/play-scala-slick-example)
with Play as web framework, 
[Slick](https://scala-slick.org/) as persistence API, 
and [H2 Database Engine](https://www.h2database.com/)
as in-memory relational database.