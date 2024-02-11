import java.util.concurrent.Executors;

public class UnknownUntilRuntimeWithExecutionThread {

    private static Runnable printInventory = () ->
            System.out.println("Printing zoo inventory");
    private static Runnable printRecords = () -> {
        for (int i = 0; i < 3; i++)
            System.out.println("Printing record: " + i);
    };

    public static void main(String[] args) {
        var executorService = Executors.newSingleThreadExecutor();
        try {
            System.out.println("Begin");
            executorService.execute(printInventory);
            executorService.execute(printRecords);
            executorService.execute(printInventory);
            System.out.println("End");
        } finally {
            executorService.shutdown();
        }
    }
}
