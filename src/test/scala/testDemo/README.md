# ScalaTest: Unifying Many Test Styles
**ScalaTest** enables different test styles.
* **JUnit**-like style as in [JUnit](https://junit.org/) with methods annotated by `@Test`
* **Spec**-like style as in [RSpec: Behaviour Driven Development for Ruby](https://rspec.info/)
* **Property-Based** Testing as in [Haskell QuickCheck](https://en.wikipedia.org/wiki/QuickCheck)

Usually you place your production code into `src/main/scala/`*package* 
and your test code into `src/test/scala/`*package*. 
The test driver should always be in the same logical package,
then it can access all package-private definitions and test them.

By placing the test code into another directory than the production code,
you can leave it away when producing the release artifact.

Look into target/scala-2.12/scala-intro-....jar

## Comfortable Assertions in ScalaTest
ScalaTest offers a well-readable language for assertions in its
[Matchers](https://www.scalatest.org/user_guide/using_matchers).
They are especially comfortable for collections, e.g.
  `List(1, 2, 3) should contain (2)`

## Plan
* Study the `StackSpec` (example-based testing)
* Study the `ListCheck` (property-based testing)