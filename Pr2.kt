fun evenOrOdd(n: Int): String = if (n % 2 == 0) "Even" else "Odd"

fun multiplyByFourOrFive(n: Int): Int = if (n % 2 == 0) n * 4 else n * 5

fun makeNegative(n: Int): Int = if (n > 0) -n else n

fun centuryFromYear(year: Int): Int = (year + 99) / 100

fun findSmallestNumber(arr: List<Int>): Int = arr.minOrNull() ?: throw IllegalArgumentException("Array is empty")

fun findTwoLargestNumbers(arr: List<Int>): List<Int> = arr.sortedDescending().take(2)

fun countPositivesSumNegatives(arr: List<Int>?): List<Int> {
    if (arr.isNullOrEmpty()) return emptyList()
    val countPositives = arr.count { it > 0 }
    val sumNegatives = arr.filter { it < 0 }.sum()
    return listOf(countPositives, sumNegatives)
}

fun countVowels(str: String): Int = str.count { it.lowercaseChar() in "aeiouy" }

fun findMiddleCharacter(s: String): String =
    if (s.length % 2 == 0) s.substring(s.length / 2 - 1, s.length / 2 + 1) else s[s.length / 2].toString()

fun multiplicationTable(n: Int): List<List<Int>> =
    List(n) { row -> List(n) { col -> (row + 1) * (col + 1) } }

fun main() {
    println("Введіть число для перевірки парності:")
    val num1 = readLine()?.toIntOrNull() ?: return
    println(evenOrOdd(num1))

    println("Введіть число для множення:")
    val num2 = readLine()?.toIntOrNull() ?: return
    println(multiplyByFourOrFive(num2))

    println("Введіть число, щоб отримати негативне значення:")
    val num3 = readLine()?.toIntOrNull() ?: return
    println(makeNegative(num3))

    println("Введіть рік для визначення століття:")
    val year = readLine()?.toIntOrNull() ?: return
    println(centuryFromYear(year))

    println("Введіть числа через пропуск для пошуку мінімального значення:")
    val numbers = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return
    println(findSmallestNumber(numbers))

    println("Введіть числа через пропуск для пошуку двох найбільших:")
    val numbers2 = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() } ?: return
    println(findTwoLargestNumbers(numbers2))

    println("Введіть числа через пропуск для підрахунку позитивних та суми негативних:")
    val numbers3 = readLine()?.split(" ")?.mapNotNull { it.toIntOrNull() }
    println(countPositivesSumNegatives(numbers3))

    println("Введіть рядок для підрахунку голосних:")
    val str = readLine() ?: return
    println(countVowels(str))

    println("Введіть рядок для пошуку середнього символу:")
    val str2 = readLine() ?: return
    println(findMiddleCharacter(str2))

    println("Введіть число N для створення таблиці множення:")
    val n = readLine()?.toIntOrNull() ?: return
    println(multiplicationTable(n))
}
