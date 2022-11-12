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
        updateTemperature()
        var numberOfSuccess = 0
        var j = 0
        do{
            numberOfSuccess = 0
            val states = problem.generateStates(actualState)
            states.forEach {
                val delta = it.cost - actualState.cost
                if (delta <= 0 || (temperature > 0 && exp(((-delta / temperature).toDouble())) > getRandom())) {
                    actualState = it
                    numberOfSuccess++
                }
            }
            updateTemperature()
            j++
        }while(numberOfSuccess!=0)
        println(actualState.cost)
        problem.printState(actualState)
    }


    private fun getRandom(): Double {
        val value = Random.nextInt(0, 8000)
        return ((value / 8000).toDouble())
    }

    private fun updateTemperature() {
        temperature = (temperature * alpha).toInt()
    }

}