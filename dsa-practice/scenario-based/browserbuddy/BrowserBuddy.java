import java.util.Stack;

public class BrowserBuddy {
    private Tab curTab;
    private final Stack<Tab> closed = new Stack<>();

    public void openTab(String url) {
        curTab = new Tab(url);
    }

    public void visit(String url) {
        if (curTab != null) {
            curTab.visit(url);
        }
    }

    public void back() {
        if (curTab != null) curTab.back();
    }

    public void fwd() {
        if (curTab != null) curTab.fwd();
    }

    public void closeTab() {
        if (curTab == null) return;
        closed.push(curTab);
        curTab = null;
    }

    public void reopenLast() {
        if (closed.isEmpty()) return;
        curTab = closed.pop();
    }

    public void show() {
        if (curTab == null) {
            System.out.println("No active tab");
            return;
        }
        System.out.println("Current: " + curTab.getUrl());
        curTab.printHist();
        System.out.println("Closed tabs in stack: " + closed.size());
    }
}

