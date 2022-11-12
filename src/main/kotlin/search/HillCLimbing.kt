package search

import problem.Problem

class HillClimbing(private var problem: Problem) {

    private var actualState = problem.getInitialStateState()

    fun getResult(){
        if(problem.objectiveTest(actualState)){
            problem.printState(actualState)
            println()
            println(actualState.cost)
        }
        else{
            val newStates = problem.generateStates(actualState)
            newStates.sortBy { it.cost }
            actualState = if(newStates[0].cost < actualState.cost){
                newStates[0]
            } else{
                problem.generateNewInitialState()
                problem.getInitialStateState()
            }
            getResult()
        }
    }
}