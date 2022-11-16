package search

import problem.Problem
import kotlin.math.exp
import kotlin.random.Random

class SimulatedAnnealing(
    private var temperature: Int,
    private val alpha: Float,
    private val problem: Problem
) {

    private var actualState = problem.getInitialStateState()

    fun getResult() {
        while (true) {
            if(temperature == 0){
                problem.printState(actualState)
                return
            }
            val states = problem.generateStates(actualState)
            states.sortBy { it.cost }
            val delta = states[0].cost - actualState.cost
            if (delta < 0 || getRandom() < exp(-delta.toDouble() / temperature)) {
                actualState = states[0]
            }
            updateTemperature()
        }
    }


    private fun getRandom(): Double {
        return Random.nextDouble(0.0, 1.0)
    }

    private fun updateTemperature() {
        temperature = (temperature * alpha).toInt()
    }

}