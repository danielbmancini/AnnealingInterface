import java.util.Random;

public abstract class Arrefecimento {

    /**
     * Evaluate whether a solution should be accepted based on the given parameters.
     *
     * @param solution    The current solution.
     * @param s           The perturbed solution.
     * @param temperature The current temperature.
     * @return The selected solution.
     */
    public Object evaluateSolution(Object solution, Object s, int temperature) {
        Random random = new Random();
        double eval = evaluator(s) - evaluator(solution);

        if (eval < 0)
            return solution;

        return Math.exp(-eval / temperature) > random.nextDouble() ? solution : s;
    }

    /**
     * Abstract method for providing a stopping condition.
     *
     * @param solution The current solution.
     * @return True if the annealing process should stop; false otherwise.
     */
    public abstract boolean stop(Object solution);

    /**
     * Perform simulated annealing to optimize a solution.
     *
     * @param solution  The initial solution.
     * @return perturbed solution.
     */

    public abstract Object solutionPerturber(Object solution);

    public Object anneal(Object initialSolution, int temperature, int minTemperature) {
        Object solution = initialSolution;
        Object solution2;

        while (temperature > minTemperature) {
            // Perturb the solution and evaluate

            System.out.println(solution);
            solution2 = solutionPerturber(solution);

            solution = evaluateSolution(solution2,solution2,temperature);
            // Update the temperature
            temperature = coolingSchedule(temperature);

            // Check the stopping condition
            if (stop(solution))
                break;

            System.out.println(solution);
        }

        return solution;
    }


    public abstract int coolingSchedule(int temperature);

    public abstract int evaluator(Object solution);
}
