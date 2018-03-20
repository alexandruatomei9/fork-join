package ro.sv.java.community;

import java.util.concurrent.ForkJoinPool;

public class Main {

    static ForkJoinPool forkJoinPool = ForkJoinPool.commonPool();

    public static void main(String[] args) {
        System.out.println("ForkJoinPool parallelism: " + forkJoinPool.getParallelism());

        /*CustomRecursiveAction customRecursiveAction = new CustomRecursiveAction("ana Are Mere! Ciresel vine si cere");
        forkJoinPool.invoke(customRecursiveAction);*/

        CustomRecursiveTask customRecursiveTask = new CustomRecursiveTask(new int[]{14,17,2,38,66});
        forkJoinPool.execute(customRecursiveTask);
        int result = customRecursiveTask.join();
        System.out.println("The result of the customRecursiveTask is:" + result);
    }
}
