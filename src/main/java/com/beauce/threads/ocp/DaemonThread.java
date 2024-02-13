package com.beauce.threads.ocp;

public class DaemonThread {

    public static void main(String[] args) {
        Thread thread = new Thread(() -> {
            try {
                Thread.sleep(10_000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
            System.out.println("Thread finished!");
        });
        thread.setDaemon(true);
        thread.start();
        System.out.println("Main Thread finished!");
    }
}
