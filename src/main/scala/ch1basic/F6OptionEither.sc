// Option and Either for expressing optionality or failure

// Let us model a person:
case class Person(name: String, email: String)

// Java style for handling an optional E-Mail address:
def print(person: Person): Unit = {
  if(person.email == null){
    println(person.name)
  }else{
    println(person.name + ", " + person.email)
  }
}
// Problems here?








// We do not see from the class definition, which attribute is mandatory, which optional.

// Convention in Scala 2: All attributes are mandatory.
// If you want an attribute optional, you should use the wrapper type Option[T].
// In Scala 3 you have to declare a variable: type || Null, if you want to have it nullable.

// Person with mandatory name and optional e-mail:
case class Person(name: String, email: Option[String] = None)

// Scala style for handling the optional E-Mail address:
def print(person: Person): Unit = person.email match {
  case None =>
    println(person.name)
  case Some(address) =>
    println(person.name + ", " + address)
}

// Option also has flatMap and map, so usable in for comprehension.
val persons = List(Person("Lisa", Some("lisa@web.de")), Person("Hans"), Person("Nina", Some("agent007@mi6.gov.uk")))
println("Print all e-mail addresses from person database:")
for{
  person <- persons
  email <- person.email // empty Option will be ignored.
} println(email)

// ============== Functional Error Handling with Either =============
// Fetch a List of Persons, for each Person fetch its account by its email,
// print the account.
type Message = String
case class Account(address: String)

def fetchPersons(): Either[Message, List[Person]] =
  //Left("Database failure")
  Right(persons)
def findByEmail(address: String): Either[Message, Account] =
  //Left(s"No account found for person with email $address")
  Right(Account(address))

// That way it works, only with side-effect.
for{
  personList <- fetchPersons()
  person <- personList
  address <- person.email
  account <- findByEmail(address)
} println(account)

// That way with result does not yet work:
/*
for{
  personList <- fetchPersons()
  person <- personList
  address <- person.email
  account <- findByEmail(address)
} yield (account)
 */

// But I do not yet fully understand that.
// I do not succeed to work it with yield.