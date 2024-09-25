
fun main() {
    val amanda = Person("Amanda", 33, "play tennis", null)
    val atiqah = Person("Atiqah", 28, "climb", amanda)

    amanda.showProfile()
    atiqah.showProfile()
}

class Person(val name: String, val age: Int, val hobby: String?, val referrer: Person?) {
    fun showProfile() {
        println("Name: $name")
        println("Age: $age")
        print("like to $hobby")
        if (referrer == null){
            println("Doesn't have a referrer.")
        }else{
            print("Has a referrer named ${referrer.name},who likes to ${referrer.hobby}")
        }
    }
}