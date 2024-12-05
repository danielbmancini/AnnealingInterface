import java.util.Random;

/*
    Estima o mínimo.
* */
public class MinimizeQuadratic extends Arrefecimento<Integer> {
    //Problema: minimizar (x−3)⁴ + 82 (O minímo deve ser 4 em x = 3)

    int min;
    Integer sol;
    static Random random = new Random();

    @Override
    public int evaluator(Integer solution){
        int val = (int) Math.pow(((int) solution - 3),4) + 4;
        if(min > val){
            min = val;
            sol = solution;
        }
        return val;
    }

    @Override
    public Integer solutionPerturber(Integer solution){
        Random random = new Random();
        int randomOffset = random.nextBoolean() ? 5 : -5;
        return  java.lang.Integer.valueOf((int) (solution +  2*random.nextDouble()*randomOffset));

    }

    @Override
    public int coolingSchedule(int temperature){
        return (int) (temperature * 0.98 );
    }

    public static void main(String[] args) {
        int initialSolution = random.nextInt(10) - 5;
        int temperature = 400;
        int minTemperature = 1;


        MinimizeQuadratic minimizeQuadratic = new MinimizeQuadratic();
        minimizeQuadratic.min = minimizeQuadratic.evaluator(initialSolution);
        //anneal(Object initialSolution, int temperature, int minTemperature, Function<Object,Object> solutionPerturber,Function<Integer,Integer> coolingSchedule)
        minimizeQuadratic.sol = initialSolution;
        System.out.println(minimizeQuadratic.anneal(initialSolution,temperature,minTemperature));
        System.out.println("min = "  + minimizeQuadratic.sol);
    }



    @Override
    public boolean stop(Integer solution){
        return false;
    }
}
