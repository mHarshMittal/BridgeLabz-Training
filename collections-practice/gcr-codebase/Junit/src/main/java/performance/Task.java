package performance;

public class Task {

    // Method that simulates a long-running task
    public String longRunningTask() {
        try {
            Thread.sleep(3000); // sleep for 3 seconds
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        return "Task Completed";
    }
}
