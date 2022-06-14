# Introduction to Scala
This little course uses material from Baeldung.

## Overview
* Text [Introduction to Scala](https://www.baeldung.com/scala/scala-intro)
## Day 2 The Object-Oriented Side of Scala
* Text [Object Oriented Programming in Scala](https://www.baeldung.com/scala/oop-intro)<br>
  Code [OopConcepts.scala](https://github.com/Baeldung/scala-tutorials/blob/master/scala-core-oop/src/main/scala/com/baeldung/scala/oopinscala/OopConcepts.scala)
* Text [Classes and Objects in Scala](https://www.baeldung.com/scala/classes-objects)<br>
  Code [classvsobject](https://github.com/Baeldung/scala-tutorials/tree/master/scala-core-oop/src/main/scala/com/baeldung/scala/classvsobject)

## Day 3 Class vs. Object vs. Case Class, Pattern Matching
* Class vs Object, Companion Object<br>Code [ObjectExamples.sc](src/main/scala/classvsobject/ObjectExamples.sc)
* Case Classes and Pattern Matching<br>
  Code [PatternMatching.sc](src/main/scala/patternmatching/PatternMatching.sc)


## Day 4 The Functional Side of Scala
* [Why Functional Programming](src/main/scala/functions/F0WhyFunctional.md)
* Functions, Recursion, Tail recursion.<br>Code [F1Recursion.sc](src/main/scala/functions/F1Recursion.sc)
* Higher Order Functions.<br>Code [F2HigherOrder.sc](src/main/scala/functions/F2HigherOrder.sc)

## Day 5 2022-06-14 Control Abstraction and Higher Order Functions
* Recap Why Functional Programming incl. Demo of Sequential vs. Parallel Computation: Project [gauss-sum](../../../gauss-sum/)
* Recap Tail Recursion
* [F3ControlAbstraction.sc](src/main/scala/functions/F3ControlAbstraction.sc)
* Higher Order Methods in Collections.<br>Code [F4CollectionMethods.sc](src/main/scala/functions/F4CollectionMethods.sc)

## Day 6 2022-06-15 Build & Test
* Build Tool [SBT](https://www.scala-sbt.org/)
* Our [build.sbt](build.sbt) SBT build script
* Structure of a mixed Scala/Java Project
* [Different Test Styles with ScalaTest](src/test/scala/testDemo/)

## Missing Topics for Introductory Course
* val/var
* lazy val
* AnyVal/AnyRef, Type Hierarchy
* Traits, Mixin-Programming
* Collections: mutable/immutable, Collection Hierarchy
* Option, Either for expressing optionality, failure
* for comprehension
