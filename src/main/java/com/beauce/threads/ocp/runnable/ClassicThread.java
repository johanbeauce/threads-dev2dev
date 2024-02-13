package com.beauce.threads.ocp.runnable;

public class ClassicThread {
    public static void main(String[] args) {
        Thread thread = new Thread(new Runnable() {
            public void run() {
                System.out.println("Hello from a thread!");
            }
        });
        thread.start();

        Thread threadWithLambda = new Thread(() -> System.out.println("Hello from a thread with lambda!"));
        threadWithLambda.start();
    }
}
