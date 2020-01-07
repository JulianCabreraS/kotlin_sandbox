class LootBox<out T>(item: T) {
    var open = false

    private var loot: T = item

    /****Returns this value if it satisfies the given predicate or null, if it doesn't.*****/
    fun fetch(): T? {
        return loot.takeIf { open }
    }
    /****Returns this value if it satisfies the given predicate or null, if it doesn't.*****/
    fun <R> fetch(lootModFunction: (T) -> R): R? {
        return lootModFunction(loot).takeIf { open }
    }
}
open class Loot(val value: Int)


/****SUBCLASS OF LOOT***/
class Fedora(val name: String,value: Int) : Loot(value)


/****SUBCLASS OF LOOT***/
class Coin(value: Int) : Loot(value)



fun main(args: Array<String>) {
    val lootBoxOne: LootBox<Fedora> = LootBox(Fedora("a generic-looking fedora", 15))
    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch()?.run {
        println("You retrieve $name from the box!")
    }

    val coin = lootBoxOne.fetch() {
        Coin(it.value * 3)
    }
    coin?.let { println(it.value) }
}


