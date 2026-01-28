import java.util.*;

class InvalidBackupPathException extends Exception {
    public InvalidBackupPathException(String msg) {
        super(msg);
    }
}

class BackupTask implements Comparable<BackupTask> {
    String path;
    int priority;

    BackupTask(String path, int priority) {
        this.path = path;
        this.priority = priority;
    }

    public int compareTo(BackupTask o) {
        return o.priority - this.priority;
    }
}

class BackupScheduler {
    PriorityQueue<BackupTask> pq = new PriorityQueue<>();

    void addTask(String path, int priority) throws InvalidBackupPathException {
        if (path == null || path.isEmpty())
            throw new InvalidBackupPathException("Invalid Path");

        pq.add(new BackupTask(path, priority));
    }

    void executeTasks() {
        while (!pq.isEmpty())
            System.out.println(pq.poll().path);
    }
}

class BackupSchedulerApp {
    public static void main(String[] args) {
        BackupScheduler b = new BackupScheduler();
        try {
            b.addTask("C:/System", 5);
            b.addTask("D:/Docs", 2);
            b.addTask("", 3); // exception
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        b.executeTasks();
    }
}
