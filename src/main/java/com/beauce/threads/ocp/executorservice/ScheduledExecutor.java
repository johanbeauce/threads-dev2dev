package com.beauce.threads.ocp.executorservice;

import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class ScheduledExecutor {
    public static void main(String[] args) {
        var executorService = Executors.newSingleThreadScheduledExecutor();
        try {
            executorService.schedule(() -> System.out.println("Task 1 finished"), 1, TimeUnit.SECONDS);
            executorService.schedule(() -> {
                System.out.println("Task 2 finished");
                return "task 2";
            }, 2, TimeUnit.SECONDS);
            executorService.schedule(() -> System.out.println("Task 3 finished"), 3, TimeUnit.SECONDS);
        }
        finally {
            executorService.shutdown();
        }
    }
}
