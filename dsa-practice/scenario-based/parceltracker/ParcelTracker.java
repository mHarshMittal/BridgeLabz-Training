
public class ParcelTracker {
    private StageNode head;
    private StageNode tail;

    public void addStage(String stage) {
        StageNode n = new StageNode(stage);
        if (head == null) {
            head = tail = n;
        } else {
            tail.next = n;
            tail = n;
        }
    }

    public boolean addCheckpointAfter(String afterStage, String checkpoint) {
        StageNode cur = head;
        while (cur != null) {
            if (cur.stage.equals(afterStage)) {
                StageNode n = new StageNode(checkpoint);
                n.next = cur.next;
                cur.next = n;
                if (cur == tail) tail = n;
                return true;
            }
            cur = cur.next;
        }
        return false;
    }

    public void markLost() {
        head = null;
        tail = null;
    }

    public void printStages() {
        if (head == null) {
            System.out.println("No tracking data (parcel lost or not created).");
            return;
        }
        StageNode cur = head;
        while (cur != null) {
            System.out.print(cur.stage);
            cur = cur.next;
            if (cur != null) System.out.print(" -> ");
        }
        System.out.println();
    }
}

