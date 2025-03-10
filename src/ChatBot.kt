import java.util.Scanner

fun main() {
    val scanner = Scanner(System.`in`)

    println("Hello! My name is DICT_Bot.")
    println("Please, remind me your name.")
    val name = scanner.nextLine()
    println("What a great name you have, $name!")

    println("Let me guess your age.")
    println("Enter remainders of dividing your age by 3, 5 and 7.")
    val remainder3 = scanner.nextInt()
    val remainder5 = scanner.nextInt()
    val remainder7 = scanner.nextInt()
    val age = (remainder3 * 70 + remainder5 * 21 + remainder7 * 15) % 105
    println("Your age is $age!")

    println("Now I will prove to you that I can count to any number you want.")
    val number = scanner.nextInt()
    for (i in 0..number) {
        println("$i!")
    }

    println("Let's test your programming knowledge.")
    println("Why do we use methods?")
    println("1. To repeat a statement multiple times.")
    println("2. To decompose a program into several small subroutines.")
    println("3. To determine the execution time of a program.")
    println("4. To interrupt the execution of a program.")

    var answer: Int
    do {
        answer = scanner.nextInt()
        if (answer != 2) {
            println("Please, try again.")
        }
    } while (answer != 2)

    println("Congratulations, have a nice day!")
}
