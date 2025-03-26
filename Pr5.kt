interface Queue<T : Any> {
    fun enqueue(element: T): Boolean
    fun dequeue(): T?
    val count: Int
    val isEmpty: Boolean
    fun peek(): T?
}

class QueueImpl<T : Any> : Queue<T> {
    private val elements: ArrayList<T> = ArrayList()

    override fun enqueue(element: T): Boolean {
        return elements.add(element)
    }

    override fun dequeue(): T? {
        return if (isEmpty) {
            null
        } else {
            elements.removeAt(0)
        }
    }

    override val count: Int
        get() = elements.size

    override val isEmpty: Boolean
        get() = elements.isEmpty()

    override fun peek(): T? {
        return if (isEmpty) {
            null
        } else {
            elements[0]
        }
    }
}

fun main() {
    val queue = QueueImpl<Int>()
    
    queue.enqueue(1)
    queue.enqueue(2)
    queue.enqueue(3)
    queue.enqueue(4)
    queue.enqueue(5)

    println(" ${queue.peek()}")

    println(" ${queue.dequeue()}")
    println(" ${queue.dequeue()}")
    println(" ${queue.dequeue()}")

    println(" ${queue.count}")
    println(" ${queue.isEmpty}")

    println(" ${queue.dequeue()}")
    println(" ${queue.dequeue()}")

    println(" ${queue.count}")
    println("${queue.isEmpty}")
}

