import problem.queen.QueenProblem
import search.HillClimbing
import search.IterativeDeepeningSearch
import search.SimulatedAnnealing
import kotlin.system.measureTimeMillis

fun main(args: Array<String>) {
    val problem = QueenProblem(11)

    val time = measureTimeMillis {
        SimulatedAnnealing(400000000, 0.999f, problem).getResult()
    }
    println("Tempo gasto: " + time)

//    SimulatedAnnealingaling(900000000,10,problem).getResult()
//    IterativeDeepeningSearch(problem).getResult()
}
