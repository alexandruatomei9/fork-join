package ro.sv.java.community;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.concurrent.ForkJoinTask;
import java.util.concurrent.RecursiveAction;

public class CustomRecursiveAction extends RecursiveAction {

    private String workLoad;
    private static final int THRESHOLD = 4;

    public CustomRecursiveAction(String workLoad) {
        this.workLoad = workLoad;
    }

    @Override
    protected void compute() {

        if (workLoad.length() > THRESHOLD) {
            ForkJoinTask.invokeAll(createSubTasks());
        } else {
            process(workLoad);
        }
    }

    private Collection<CustomRecursiveAction> createSubTasks() {

        List<CustomRecursiveAction> subTasks = new ArrayList<>();

        String partOne = workLoad.substring(0, workLoad.length() / 2);
        String partTwo = workLoad.substring(workLoad.length() / 2, workLoad.length());

        subTasks.add(new CustomRecursiveAction(partOne));
        subTasks.add(new CustomRecursiveAction(partTwo));

        return subTasks;
    }

    private void process(String work) {
        String result = work.toUpperCase();
        System.out.println("This result - (" + result + ") - was processed by " + Thread.currentThread()
                .getName());
    }
}
