class LootBox2<T>(vararg item: T) {
    var open = false

    private var loot:Array <out T> = item

    /****Returns this value if it satisfies the given predicate or null, if it doesn't.*****/
    fun fetch(item: Int): T? {
        return loot[item].takeIf { open }
    }
    /****Returns this value if it satisfies the given predicate or null, if it doesn't.*****/
    fun <R> fetch(item: Int, lootModFunction: (T) -> R): R? {
        return lootModFunction(loot[item]).takeIf { open }
    }
}



fun main(args: Array<String>) {
    val lootBoxOne: LootBox2<Fedora> = LootBox2(
        Fedora("a generic-looking fedora", 15),
        Fedora("a dazzling magenta fedora", 25)
        )


    val lootBoxTwo: LootBox<Coin> = LootBox(Coin(15))

    lootBoxOne.open = true
    lootBoxOne.fetch(1)?.run{ println("You retrieve $name from the box!") }

    val coin = lootBoxOne.fetch(0)
    {
        Coin(it.value * 3)
    }
    coin?.let { println(it.value) }
}


