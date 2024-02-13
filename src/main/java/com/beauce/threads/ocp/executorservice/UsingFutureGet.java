package com.beauce.threads.ocp.executorservice;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class UsingFutureGet {
    private static int counter = 0;
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        try {
            Future<?> result = service.submit(() -> {
                for (int i = 0; i < 1_000_000; i++) counter++;
            });
            result.get(10, TimeUnit.SECONDS); // Returns null for Runnable
            System.out.println("Reached!");
        }
        catch (TimeoutException e) {
            System.out.println("Not reached in time");
        }
        catch (ExecutionException | InterruptedException e) {
            System.out.println("Execution fails:" + e.getMessage());
            throw new RuntimeException(e);
        }
        finally {
            service.shutdown();
        }
    }
}
