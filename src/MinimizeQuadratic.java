import java.util.Random;
import java.util.function.Function;
/*
* Override:
* evaluationFunction (Object s)
* coolingSchedule(int temperature)
* perturbSolution(Object s)
* stop(Object solution)
* */
public class MinimizeQuadratic extends Arrefecimento {
    //Problema: minimizar (x−3)⁴ + 82 (O minímo deve ser 4 em x = 3)

    int min;
    Object sol;
    static Random random = new Random();

    @Override
    public int evaluator(Object solution){
        int val = (int) Math.pow(((int) solution - 3),4) + 4;
        if(min > val){
            min = val;
            sol = solution;
        }
        return val;
    }

    @Override
    public Object solutionPerturber(Object solution){
        Random random = new Random();
        int randomOffset = random.nextBoolean() ? 1 : -1;
        return (int) solution + randomOffset;

    }

    @Override
    public int coolingSchedule(int temperature){
        return (int) (temperature * 0.98);
    }

    public static void main(String[] args) {
        int initialSolution = random.nextInt(20);
        int temperature = 600;
        int minTemperature = 1;


        MinimizeQuadratic minimizeQuadratic = new MinimizeQuadratic();
        minimizeQuadratic.min = minimizeQuadratic.evaluator(initialSolution);
        //anneal(Object initialSolution, int temperature, int minTemperature, Function<Object,Object> solutionPerturber,Function<Integer,Integer> coolingSchedule)
        System.out.println(minimizeQuadratic.anneal(initialSolution,temperature,minTemperature));
        System.out.println("min = "  + minimizeQuadratic.sol);
    }



    @Override
    public boolean stop(Object solution){
        return false;
    }
}
