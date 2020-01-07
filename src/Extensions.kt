
val String.numVowels
    get() = count { "aeiouy".contains(it) }

fun String.addEnthusiasm(amount: Int=1)  = this + "!".repeat(amount)

fun Any.easyPrint() = println(this)


fun <T>T.easyPrint2(): T {
    println(this)
    return this
}

/************Example of Nullable types**************/
infix fun String?.printWithDefault(default: String) = print(this ?: default)


fun main(args: Array<String>) {
    println("Madrigal has left the building".addEnthusiasm())

    "Madrigal has left the building".addEnthusiasm().easyPrint()
     /********GENERICS **************/
    "Madrigal has left the building".easyPrint2().addEnthusiasm().easyPrint2()

    /********WITH INTEGERS*****/
    42.easyPrint()

    "how many vowels?".numVowels.easyPrint()

    val nullableString: String? = null
    nullableString printWithDefault "Default string"

    /***************Example of infix or without infix*************/
    null printWithDefault "Default string"   // With infix
    null.printWithDefault("Default string")  // Without infix



}


