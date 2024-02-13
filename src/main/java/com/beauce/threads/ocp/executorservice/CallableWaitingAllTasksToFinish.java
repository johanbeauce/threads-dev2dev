package com.beauce.threads.ocp.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class CallableWaitingAllTasksToFinish {
    public static void main(String[] args) {
        var executorService = Executors.newSingleThreadExecutor();
        try {
            executorService.submit(() -> {
                Thread.sleep(1000);
                System.out.println("Task 1 finished");
                return null;
            });
            executorService.submit(() -> {
                Thread.sleep(2000);
                System.out.println("Task 2 finished");
                return null;
            });
            executorService.submit(() -> {
                Thread.sleep(3000);
                System.out.println("Task 3 finished");
                return null;
            });
        } finally {
            executorService.shutdown();
        }
        try {
            executorService.awaitTermination(10, TimeUnit.SECONDS);
            if (executorService.isTerminated()) {
                System.out.println("All tasks finished");
            }
            else {
                System.out.println("At least one task is still running");
            }
        }
        catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}
