public class UnknownUntilRuntime {

    private static Runnable printInventory = () ->
            System.out.println("Printing zoo inventory");
    private static Runnable printRecords = () ->
    {
        for (int i = 0; i < 3; i++)
            System.out.println("Printing record: " + i);
    };

    public static void main(String[] args) {
        System.out.println("Begin");
        new Thread(printInventory).start();
        new Thread(printRecords).start();
        new Thread(printInventory).start();
        System.out.println("End");
    }
}
