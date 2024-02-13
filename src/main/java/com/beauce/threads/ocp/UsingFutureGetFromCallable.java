package com.beauce.threads.ocp;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class UsingFutureGetFromCallable {
    public static void main(String[] args) {
        ExecutorService service = Executors.newSingleThreadExecutor();
        var submit = service.submit(() -> 3 + 4);
        try {
            var result = submit.get();
            System.out.println("result is " + result);
        }
        catch (InterruptedException | ExecutionException e) {
            throw new RuntimeException(e);
        }
    }
}
