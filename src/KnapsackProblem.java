import java.util.ArrayList;
import java.util.Random;

public class KnapsackProblem extends Arrefecimento<ArrayList<Integer>> {
    // Lista: Itens na bolsa
    int maxValue;
    int maxWeight = 878;
    int[] weights = {92, 4, 43, 83, 84, 68, 92, 82, 6, 44, 32, 18, 56, 83, 25, 96, 70, 48, 14, 58};
    int[] values = {44, 46, 90, 72, 91, 40, 75, 35, 8, 54, 78, 40, 77, 15, 61, 17, 75,
            29, 75, 63};
    int[] valuesCopy = {44, 46, 90, 72, 91, 40, 75, 35, 8, 54, 78, 40, 77, 15, 61, 17, 75,
            29, 75, 63};
    int currentWeight = 0;

    @Override
    public int evaluator(ArrayList<Integer> list) {
        int count = 0;
        for (int a : list)
            for (int i = 0; i < values.length; i++) {
                if (values[i] == a) {
                    count += values[i]; // Return the index if the element is found
                }
            }

        if (maxValue < count)
            count = maxValue;
        return count;
    }


    @Override
    public int coolingSchedule(int temperature) {
        return (int) (temperature * 0.999);
    }

    @Override
    public boolean stop(ArrayList<Integer> solution) {
        return false;
    }

    @Override
    public ArrayList<Integer> solutionPerturber(ArrayList<Integer> solution) {
        //Começar com saco cheio dos objetos de maior valor, e perturbar a partir daí
        //retirar item aleatorio da lista com probabiidade dependente
        Random random = new Random();
        int index = random.nextInt(solution.size());
        int element = solution.set(index, 0);
        int index2 = 0;
        for (int i = 0; i < weights.length; i++) {
            if (weights[i] == element) {
                index2 = i;
            }
        }
        currentWeight -= weights[index2];
        values[index2] = valuesCopy[index2];

        while (true) {
            int i = random.nextInt(weights.length);
            if (weights[i] <= maxWeight - currentWeight && values[i] != 0) {
                solution.set(index2, values[i]);
                values[i] = 0;
                currentWeight += weights[i];
                System.out.println("weight" + currentWeight);
                break;
            }
        }


        return solution;
    }

    public static void main(String[] args) {
        int temperature = 2000;
        int minTemperature = 1;


        ArrayList<Integer> list = new ArrayList<>();

        KnapsackProblem problem = new KnapsackProblem();

        for (int i = problem.weights.length - 1; i >= 0; --i) {
            if (problem.currentWeight + problem.weights[i] <= problem.maxWeight) {
                list.add(problem.values[i]);
                problem.currentWeight += problem.weights[i];
                problem.values[i] = 0;
            } else {
                list.add(0);
            }
        }

        for (int i : list)
            problem.maxValue += i;

        problem.anneal(list, temperature, minTemperature);

        System.out.println("solution = " + problem.maxValue);
    }

}
