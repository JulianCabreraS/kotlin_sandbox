fun main(args: Array<String>) {

   //Example of anonymous function without parameter
    var greetingFunction ={
        val currentYear = 2018
        "Welcome to SimVillage, Mayor ! (copyright $currentYear)"
    }
    println(greetingFunction())

    //Anonymous function with parameter
    var greetingFunction2: (String)-> String ={playerName->
        val currentYear = 2018
        "Welcome to SimVillage, Mayor! $playerName !(copyright $currentYear)"
    }
    println(greetingFunction2("Guyal"))

    //Only one parameter, can use it
    var greetingFunction3: (String)-> String ={
        val currentYear = 2018
        "Welcome to SimVillage, Mayor! $it !(copyright $currentYear)"
    }
    println(greetingFunction3("Guyal"))

    //Multiple parameters
    var greetingFunction4: (String, Int)-> String ={ playerName, numBuilding->
        val currentYear = 2018
        println("Adding $numBuilding houses")
        "Welcome to SimVillage, Mayor! $playerName !(copyright $currentYear)"
    }
    println(greetingFunction4("Guyal",2))

    runSimulation("Guyal", ::printConstructionCost, greetingFunction4)

}

inline fun runSimulation(
    playerName: String,
    costPrinter:(Int) -> Unit,
    greetingFunction: (String, Int)-> String
    ){
    val numBuildings = (1..3).shuffled().last()
    costPrinter(numBuildings)
    println(greetingFunction(playerName,numBuildings))
}

fun printConstructionCost(numBuilding: Int){
    val cost =500
    println("Construction cost: ${cost * numBuilding}")

}