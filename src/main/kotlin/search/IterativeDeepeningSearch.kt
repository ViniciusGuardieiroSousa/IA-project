package search

import problem.Problem
import problem.States

class IterativeDeepeningSearch(val problem: Problem) {
    private var d = 0

    fun getResult(): Boolean {
        val result = search(problem.getInitialStateState())
        return if (result)
            true
        else {
            d++
            getResult()
        }
    }

    private fun search(state: States): Boolean {
        if (problem.objectiveTest(state)) {
            problem.printState(state)
            return true
        } else {
            expand(state)?.forEach {
                val result = search(it)
                if(result){
                    return true
                }
            }
        }
        return false
    }

    fun expand(node: States): List<States>? {
        if (d == node.d)
            return null
        val states = problem.generateStates(node)
        return states
    }
}