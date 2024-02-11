public class InterruptMainThread {
    private static int counter = 0;
    public static void main(String[] args) {
        Thread mainThread = Thread.currentThread();
        new Thread(() -> {
            for (int i = 0; i < 1_000_000; i++) {
                counter++;
            }
            mainThread.interrupt();
        }).start();
        while (counter < 1_000_000) {
            System.out.println("Not reached yet");
            try {
                Thread.sleep(10_000);
            }
            catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println("Reached counter of " + counter);
    }
}
