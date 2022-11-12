import problem.queen.QueenProblem
import search.HillClimbing
import search.IterativeDeepeningSearch

fun main(args: Array<String>) {
   val problem = QueenProblem(4)
//    SimulatedAnnealing(10000,0.99f,problem).getResult()
    HillClimbing(problem).getResult()
}
