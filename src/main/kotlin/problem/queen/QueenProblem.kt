package problem.queen

import problem.Problem
import problem.States
import kotlin.random.Random

class QueenProblem(val n: Int) : Problem {

    private val firstBoard = QueenState(n)

    init {
        randomState()
    }

    override fun getInitialStateState(): States = firstBoard

    override fun generateStates(state : States) : ArrayList<States> {
        val newStates = arrayListOf<States>()
        state.board.forEachIndexed { index, it ->
            for (i in 0 until n) {
                if (i != it) {
                    val newState = QueenState(n, state.d + 1)
                    newState.board = state.board.copyOf()
                    newState.board[index] = i
                    newState.calculateCost()
                    newStates.add(newState)
                }
            }
        }
        return newStates
    }

    override fun objectiveTest(state: States): Boolean {
        return state.cost == 0
    }

    override fun printState(state : States) {
        val boardPrint : ArrayList<ArrayList<Char>> = arrayListOf()
        for(i in 0 until n){
            var aux = arrayListOf<Char>()
            for(j in 0 until n){
                aux.add('X')
            }
            boardPrint.add(aux)
        }
        state.board.forEachIndexed{ index, it->
            boardPrint[index][it] = 'R'
        }
        for(i in 0 until n){
            for(j in 0 until n){
                print( "${boardPrint[i][j]} ")
            }
            println()
        }
    }

    override fun generateNewInitialState() {
        randomState()
    }

    private fun randomState(){
        firstBoard.board.forEachIndexed { index, i ->
            firstBoard.board[index] = Random.nextInt(0, n)
        }
        firstBoard.calculateCost()
    }

}