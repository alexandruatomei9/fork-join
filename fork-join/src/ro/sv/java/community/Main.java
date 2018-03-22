package ro.sv.java.community;

import java.util.Random;
import java.util.concurrent.ForkJoinPool;

public class Main {

    static ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    public static void main(String[] args) {
        System.out.println("ForkJoinPool parallelism: " + forkJoinPool.getParallelism());

        double[] array = createArrayOfRandomDoubles(9999999);
        int n = new ForkJoinPool().invoke(new CountDoublesTask(array));
        System.out.println("Found " + n + " values");

        /*CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("ana are mere! ciresel vine si cere");
        forkJoinPool.invoke(customRecursiveAction);*/

        /*CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(new int[]{14,17,2,38,66});
        forkJoinPool.execute(customRecursiveTask);
        int result = customRecursiveTask.join();
        System.out.println("The result of the customRecursiveTask is:" + result);*/
    }

    static double[] createArrayOfRandomDoubles(int size) {
        Random random = new Random();
        double[] array = new double[size];

        for (int i = 0; i < size; i++) {
            array[i] = random.nextDouble();
        }

        return array;
    }
}
