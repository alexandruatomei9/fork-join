package ro.sv.java.community;

import java.util.Arrays;
import java.util.concurrent.RecursiveTask;

/**
 * Counts the values < 0.5 in the given array
 */
public class CountDoublesTask extends RecursiveTask<Integer> {
    private double[] array;

    public CountDoublesTask(double[] array) {
        this.array = array;
    }

    protected Integer compute() {
        int subCount;
        if (array.length < 10) {
            subCount = 0;
            for (int i = 0; i < array.length; i++) {
                if (array[i] < 0.5) subCount++;
            }
        } else {
            CountDoublesTask left = new CountDoublesTask(Arrays.copyOfRange(array, 0, array.length / 2));
            left.fork();
            CountDoublesTask right = new CountDoublesTask(Arrays.copyOfRange(array, array.length / 2, array.length));
            right.fork();
            subCount = left.join();
            subCount += right.join();
        }
        return subCount;
    }
}
