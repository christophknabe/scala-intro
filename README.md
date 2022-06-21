# Introduction to Scala
This little course uses material from Baeldung.

## Overview
* Text [Introduction to Scala](https://www.baeldung.com/scala/scala-intro)
## Day 2 The Object-Oriented Side of Scala 2022-06-07
* Text [Object Oriented Programming in Scala](https://www.baeldung.com/scala/oop-intro)<br>
  Code [OopConcepts.scala](https://github.com/Baeldung/scala-tutorials/blob/master/scala-core-oop/src/main/scala/com/baeldung/scala/oopinscala/OopConcepts.scala)
* Text [Classes and Objects in Scala](https://www.baeldung.com/scala/classes-objects)<br>
  Code [classvsobject](https://github.com/Baeldung/scala-tutorials/tree/master/scala-core-oop/src/main/scala/com/baeldung/scala/classvsobject)

## Day 3 Class vs. Object vs. Case Class, Pattern Matching 2022-06-08
* Class vs Object, Companion Object<br>Code [ObjectExamples.sc](src/main/scala/classvsobject/ObjectExamples.sc)
* Case Classes and Pattern Matching<br>
  Code [PatternMatching.sc](src/main/scala/patternmatching/PatternMatching.sc)


## Day 4 The Functional Side of Scala 2022-06-09
* [Why Functional Programming](src/main/scala/functions/F0WhyFunctional.md)
* Functions, Recursion, Tail recursion.<br>Code [F1Recursion.sc](src/main/scala/functions/F1Recursion.sc)
* Higher Order Functions.<br>Code [F2HigherOrder.sc](src/main/scala/functions/F2HigherOrder.sc)

## Day 5 Control Abstraction and Higher Order Functions 2022-06-14
* Recap Why Functional Programming incl. Demo of Sequential vs. Parallel Computation: Project [gauss-sum](../../../gauss-sum/)
* Recap Tail Recursion
* [F3ControlAbstraction.sc](src/main/scala/functions/F3ControlAbstraction.sc)
* Higher Order Methods in Collections.<br>Code [F4CollectionMethods.sc](src/main/scala/functions/F4CollectionMethods.sc)

## Day 6 Build & Test 2022-06-15
* Build Tool [SBT](https://www.scala-sbt.org/)
* Our [build.sbt](build.sbt) SBT build script
* Structure of a mixed Scala/Java Project
* Life Cycle: `sbt clean`, `sbt compile`, `sbt test`, `sbt package` 
* Run the `Main` object from command line: `sbt run`
* Import an **SBT** project into your IDE: `actor-ping-pong`
* [Different Test Styles with ScalaTest](src/test/scala/testDemo/)

## Day 7 Missing Topics for Introductory Course 2022-06-16
* val/var
* Evaluation mode: strict vs. lazy vs. by-name
* AnyVal/AnyRef, Type Hierarchy
* Java Compatibility features
* Traits, Mixin-Programming
* Collections: mutable/immutable, Collection Hierarchy
* for comprehension
* Option/Either for expressing optionality/failure

I tried to cover them all in directory [ch1basic](src/main/scala/ch1basic), 
although we progressed only to class `F3TraitsAndCollectionHierarchy` with the 
link to the Collections Hierarchy graph.

## Day 8 Implementing a REST Server using the Play Webframework 2022-06-21 