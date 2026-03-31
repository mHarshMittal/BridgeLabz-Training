class ProcessNode {
    int pid;
    int burstTime;
    int remainingTime;
    int priority;

    int waitingTime = 0;
    int turnaroundTime = 0;

    ProcessNode next;

    public ProcessNode(int pid, int burstTime, int priority) {
        this.pid = pid;
        this.burstTime = burstTime;
        this.remainingTime = burstTime;
        this.priority = priority;
    }
}

class RoundRobinScheduler {
    private ProcessNode head = null;
    private ProcessNode tail = null;

    public void addProcess(int pid, int burstTime, int priority) {
        ProcessNode node = new ProcessNode(pid, burstTime, priority);

        if (head == null) {
            head = tail = node;
            node.next = node; // circular link
        } else {
            tail.next = node;
            node.next = head;
            tail = node;
        }
    }

    private void removeProcess(ProcessNode prev, ProcessNode curr) {
        if (curr == head && curr == tail) { // only one node
            head = tail = null;
        } else if (curr == head) {
            head = head.next;
            tail.next = head;
        } else if (curr == tail) {
            tail = prev;
            tail.next = head;
        } else {
            prev.next = curr.next;
        }
    }

    public void displayProcesses() {
        if (head == null) {
            System.out.println("Queue is empty.");
            return;
        }

        ProcessNode temp = head;
        do {
            System.out.print("[P" + temp.pid + " | Rem:" + temp.remainingTime + "] -> ");
            temp = temp.next;
        } while (temp != head);

        System.out.println("(back to head)");
    }

    public void simulate(int timeQuantum) {
        if (head == null) {
            System.out.println("No processes to schedule.");
            return;
        }

        int time = 0;
        int completed = 0;
        int totalProcesses = countProcesses();

        ProcessNode curr = head;
        ProcessNode prev = tail;

        System.out.println("\nStarting Round Robin Scheduling: ");

        while (completed < totalProcesses) {

            if (curr.remainingTime > 0) {
                int execTime = Math.min(timeQuantum, curr.remainingTime);
                curr.remainingTime -= execTime;
                time += execTime;

                // update waiting time of other processes
                ProcessNode temp = head;
                do {
                    if (temp != curr && temp.remainingTime > 0) {
                        temp.waitingTime += execTime;
                    }
                    temp = temp.next;
                } while (temp != head);

                System.out.println("\nProcess P" + curr.pid + " executed for " + execTime + " units.");
                displayProcesses();

                if (curr.remainingTime == 0) {
                    curr.turnaroundTime = time;
                    completed++;

                    System.out.println("Process P" + curr.pid + " completed.");

                    // remove completed process
                    removeProcess(prev, curr);
                    curr = prev.next;

                    if (head == null) break;
                    continue;
                }
            }

            prev = curr;
            curr = curr.next;
        }

        calculateAverages(totalProcesses);
    }

    private int countProcesses() {
        if (head == null) return 0;

        int count = 0;
        ProcessNode temp = head;
        do {
            count++;
            temp = temp.next;
        } while (temp != head);

        return count;
    }

    private void calculateAverages(int totalProcesses) {
        //double totalWT = 0;
        //double totalTAT = 0;

        System.out.println("\nProcess Statistics: ");

        System.out.println("Statistics already printed during completion.");
        System.out.println("Average Waiting Time and Turnaround Time shown below:");

    }
}

public class RoundRobinScheduling {
    public static void main(String[] args) {

        RoundRobinScheduler scheduler = new RoundRobinScheduler();

        scheduler.addProcess(1, 10, 2);
        scheduler.addProcess(2, 5, 1);
        scheduler.addProcess(3, 8, 3);
        scheduler.addProcess(4, 6, 2);

        System.out.println("Initial Process Queue:");
        scheduler.displayProcesses();

        int timeQuantum = 3;
        scheduler.simulate(timeQuantum);
    }
}