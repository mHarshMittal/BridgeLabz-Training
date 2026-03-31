class TaskNode {
    int taskId;
    String taskName;
    int priority;
    String dueDate;

    TaskNode next;

    public TaskNode(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }

    @Override
    public String toString() {
        return taskId + " | " + taskName + " | Priority: " + priority + " | Due: " + dueDate;
    }
}

class CircularTaskList {
    private TaskNode head;
    private TaskNode current;

    // Add at beginning
    public void addAtBeginning(int id, String name, int priority, String dueDate) {
        TaskNode node = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = node;
            node.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        node.next = head;
        temp.next = node;
        head = node;
    }

    // Add at end
    public void addAtEnd(int id, String name, int priority, String dueDate) {
        TaskNode node = new TaskNode(id, name, priority, dueDate);

        if (head == null) {
            head = node;
            node.next = head;
            current = head;
            return;
        }

        TaskNode temp = head;
        while (temp.next != head) {
            temp = temp.next;
        }

        temp.next = node;
        node.next = head;
    }

    // Add at specific position (0-based)
    public void addAtPosition(int pos, int id, String name, int priority, String dueDate) {
        if (pos <= 0 || head == null) {
            addAtBeginning(id, name, priority, dueDate);
            return;
        }

        TaskNode node = new TaskNode(id, name, priority, dueDate);
        TaskNode curr = head;
        int index = 0;

        while (curr.next != head && index < pos - 1) {
            curr = curr.next;
            index++;
        }

        node.next = curr.next;
        curr.next = node;
    }

    // Remove by Task ID
    public void removeById(int id) {
        if (head == null) return;

        TaskNode curr = head;
        TaskNode prev = null;

        do {
            if (curr.taskId == id) {

                // only one node
                if (curr == head && curr.next == head) {
                    head = null;
                    current = null;
                    return;
                }

                // deleting head
                if (curr == head) {
                    TaskNode temp = head;
                    while (temp.next != head) {
                        temp = temp.next;
                    }
                    head = head.next;
                    temp.next = head;
                    if (current == curr) current = head;
                } 
                else {
                    prev.next = curr.next;
                    if (current == curr) current = curr.next;
                }

                System.out.println("Task removed: " + id);
                return;
            }

            prev = curr;
            curr = curr.next;

        } while (curr != head);

        System.out.println("Task not found: " + id);
    }

    // View current task and move to next
    public void viewAndMoveNext() {
        if (current == null) {
            System.out.println("No tasks available.");
            return;
        }

        System.out.println("Current Task: " + current);
        current = current.next;
    }

    // Display all tasks from head
    public void displayAll() {
        if (head == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }

        TaskNode temp = head;
        do {
            System.out.println(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search by priority
    public void searchByPriority(int priority) {
        if (head == null) {
            System.out.println("No tasks in scheduler.");
            return;
        }

        TaskNode temp = head;
        boolean found = false;

        do {
            if (temp.priority == priority) {
                System.out.println(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);

        if (!found) {
            System.out.println("No task found with priority: " + priority);
        }
    }
}

public class TaskScheduler {
    public static void main(String[] args) {

        CircularTaskList scheduler = new CircularTaskList();

        scheduler.addAtEnd(1, "Submit Assignment", 2, "10-01-2026");
        scheduler.addAtEnd(2, "Prepare Slides", 1, "12-01-2026");
        scheduler.addAtBeginning(3, "Buy Groceries", 3, "09-01-2026");
        scheduler.addAtPosition(1, 4, "Team Meeting", 1, "11-01-2026");

        System.out.println("\nAll Tasks:");
        scheduler.displayAll();

        System.out.println("\nSearch by Priority = 1:");
        scheduler.searchByPriority(1);

        System.out.println("\nTask Scheduler Cycle:");
        scheduler.viewAndMoveNext();
        scheduler.viewAndMoveNext();
        scheduler.viewAndMoveNext();

        System.out.println("\nRemoving Task with ID 2:");
        scheduler.removeById(2);

        System.out.println("\nAll Tasks After Deletion:");
        scheduler.displayAll();
    }
}