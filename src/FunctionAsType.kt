fun main(args: Array<String>) {
    runSimulation()
}

fun runSimulation(){
    val greetingFunction = configureGreetingFunction()
    println(greetingFunction("Guyal"))
    println(greetingFunction("Guyal"))
}

fun configureGreetingFunction():
            (String)-> String //Returns a function that accepts a string and return a string
    {
    val structureType = "hospitals"
    var numBuilding =5
    return {playerName: String ->
        var currentYear = 2018
        numBuilding += 1
        println("Adding $numBuilding $structureType")
        "Welcome to Sim Village, $playerName (copyright $currentYear)"
    }

}
