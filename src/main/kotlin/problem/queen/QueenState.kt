package problem.queen

import problem.States
import kotlin.math.abs
import kotlin.random.Random

class QueenState(private val n: Int, override var d: Int = 0) : States {

    override var cost: Int = 0
    override var board: IntArray = IntArray(n)

    fun calculateCost() {
        var numberOfAllAttacks = 0
        for (i in 0 until n) {
            numberOfAllAttacks += getAttacks(i)
        }
        cost = numberOfAllAttacks
    }

    private fun getAttacks(indexActual: Int): Int {
        var numberOfAttacks = 0
        val position = board[indexActual]
        for (i in (indexActual + 1) until n) {
            val diff = i - indexActual
            if (position == board[i] || (position - diff) == board[i] || (position + diff) == board[i]) {
                numberOfAttacks++
            }
        }
        return numberOfAttacks
    }

    override fun equals(other: Any?): Boolean {
        if (other is QueenState) {
            return other.board contentEquals this.board
        }
        return false
    }
}