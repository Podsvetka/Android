import kotlin.random.Random

fun main() {
    val options = listOf("Камінь", "Ножиці", "Папір")
    val computerChoice = options[Random.nextInt(options.size)]

    println("Комп'ютер обрав: $computerChoice")

    var userChoice: String?
    do {
        println("Оберіть: Камінь, Ножиці или Папір")
        userChoice = readLine()?.capitalize()
        if (userChoice !in options) {
            println("Помилка! Будь ласка, виберіть одне із запропонованих слів.")
        }
    } while (userChoice !in options)

    when {
        userChoice == computerChoice -> println("Нічия!")
        userChoice == "Камінь" && computerChoice == "Ножиці" ||
                userChoice == "Ножиці" && computerChoice == "Папір" ||
                userChoice == "Папір" && computerChoice == "Камінь" ->
            println("Ви виграли!")
        else -> println("Комп'ютер виграв!")
    }
}

