class TextState {
    String content;
    TextState prev;
    TextState next;

    public TextState(String content) {
        this.content = content;
        this.prev = null;
        this.next = null;
    }
}

class UndoRedoManager {
    private TextState head;
    private TextState tail;
    private TextState current;
    private int size;
    private final int MAX_HISTORY = 10;

    public UndoRedoManager() {
        head = tail = current = null;
        size = 0;
    }

    public void addState(String content) {
        TextState newState = new TextState(content);

        // If we are not at the latest state, remove redo history
        if (current != null && current.next != null) {
            current.next.prev = null;
            current.next = null;
            tail = current;
            recalcSize();
        }

        if (head == null) {
            head = tail = current = newState;
            size = 1;
        } else {
            tail.next = newState;
            newState.prev = tail;
            tail = newState;
            current = newState;
            size++;
        }

        // Enforce max history size
        if (size > MAX_HISTORY) {
            head = head.next;
            head.prev = null;
            size--;
        }
    }

    public void undo() {
        if (current == null || current.prev == null) {
            System.out.println("Nothing to undo.");
            return;
        }
        current = current.prev;
        System.out.println("Undo performed.");
    }

    public void redo() {
        if (current == null || current.next == null) {
            System.out.println("Nothing to redo.");
            return;
        }
        current = current.next;
        System.out.println("Redo performed.");
    }

    public void displayCurrentState() {
        if (current == null) {
            System.out.println("No text available.");
        } else {
            System.out.println("Current Text: " + current.content);
        }
    }

    private void recalcSize() {
        int count = 0;
        TextState temp = head;
        while (temp != null) {
            count++;
            temp = temp.next;
        }
        size = count;
    }
}


public class TextEditorUndoRedo {
    public static void main(String[] args) {

        UndoRedoManager manager = new UndoRedoManager();

        manager.addState("Hello");
        manager.addState("Hello World");
        manager.addState("Hello World!");
        manager.addState("Hello World!!");

        manager.displayCurrentState();

        manager.undo();
        manager.displayCurrentState();

        manager.undo();
        manager.displayCurrentState();

        manager.redo();
        manager.displayCurrentState();

        manager.addState("Hello Java!");
        manager.displayCurrentState();

        manager.redo();   // should not work because redo history was cleared
    }
}