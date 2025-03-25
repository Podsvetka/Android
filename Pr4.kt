fun createCinema(rows: Int, seatsPerRow: Int): Array<CharArray> {
    return Array(rows) { CharArray(seatsPerRow) { 'S' } }
}

fun showSeats(cinema: Array<CharArray>) {
    println("Cinema:")
    print("  ")
    for (i in 1..cinema[0].size) print("$i ")
    println()
    for (i in cinema.indices) {
        print("${i + 1} ")
        println(cinema[i].joinToString(" "))
    }
}

fun calculateTicketPrice(rows: Int, seatsPerRow: Int, rowNumber: Int): Int {
    return if (rows * seatsPerRow <= 60 || rowNumber <= rows / 2) 10 else 8
}

fun buyTicket(cinema: Array<CharArray>, rows: Int, seatsPerRow: Int, stats: MutableMap<String, Int>) {
    while (true) {
        try {
            print("Enter a row number: ")
            val rowNumber = readln().toInt()
            print("Enter a seat number in that row: ")
            val seatNumber = readln().toInt()

            if (rowNumber !in 1..rows || seatNumber !in 1..seatsPerRow) {
                println("Wrong input!")
                continue
            }
            if (cinema[rowNumber - 1][seatNumber - 1] == 'B') {
                println("That ticket has already been purchased!")
                continue
            }

            val price = calculateTicketPrice(rows, seatsPerRow, rowNumber)
            println("Ticket price: $$price")
            cinema[rowNumber - 1][seatNumber - 1] = 'B'

            stats["purchasedTickets"] = stats["purchasedTickets"]!! + 1
            stats["currentIncome"] = stats["currentIncome"]!! + price
            break
        } catch (e: Exception) {
            println("Wrong input!")
        }
    }
}

fun showStatistics(rows: Int, seatsPerRow: Int, stats: Map<String, Int>) {
    val totalSeats = rows * seatsPerRow
    val totalIncome = (1..rows).sumOf { calculateTicketPrice(rows, seatsPerRow, it) * seatsPerRow }
    val percentage = if (totalSeats > 0) stats["purchasedTickets"]!!.toDouble() / totalSeats * 100 else 0.0

    println("Number of purchased tickets: ${stats["purchasedTickets"]}")
    println("Percentage: ${"%.2f".format(percentage)}%")
    println("Current income: $${stats["currentIncome"]}")
    println("Total income: $$totalIncome")
}

fun main() {
    print("Enter the number of rows: ")
    val rows = readln().toInt()
    print("Enter the number of seats in each row: ")
    val seatsPerRow = readln().toInt()

    val cinema = createCinema(rows, seatsPerRow)
    val stats = mutableMapOf("purchasedTickets" to 0, "currentIncome" to 0)

    while (true) {
        println("\n1. Show the seats")
        println("2. Buy a ticket")
        println("3. Statistics")
        println("0. Exit")
        when (readln()) {
            "1" -> showSeats(cinema)
            "2" -> buyTicket(cinema, rows, seatsPerRow, stats)
            "3" -> showStatistics(rows, seatsPerRow, stats)
            "0" -> return
            else -> println("Wrong input!")
        }
    }
}
