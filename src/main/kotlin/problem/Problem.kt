package problem

interface Problem {
    fun getInitialStateState(): States
    fun generateStates(state: States): ArrayList<States>
    fun objectiveTest(state: States): Boolean
    fun printState(state : States)
    fun generateNewInitialState()
}