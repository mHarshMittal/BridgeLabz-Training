public class BackgroundJobExecutor {
    public static void main(String[] args) {
        Runnable job = () -> System.out.println("Background job running");

        Thread thread = new Thread(job);
        thread.start();
    }
}
