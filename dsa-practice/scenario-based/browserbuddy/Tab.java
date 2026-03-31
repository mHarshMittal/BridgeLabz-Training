
public class Tab {
    private HistNode cur;

    public Tab(String firstUrl) {
        visit(firstUrl);
    }

    public void visit(String url) {
        HistNode n = new HistNode(url);
        if (cur != null) {
            // drop forward chain for memory efficiency
            cur.next = null;
            n.prev = cur;
        }
        cur = n;
    }

    public void back() {
        if (cur != null && cur.prev != null) {
            cur = cur.prev;
        }
    }

    public void fwd() {
        if (cur != null && cur.next != null) {
            cur = cur.next;
        }
    }

    public String getUrl() {
        return cur == null ? null : cur.url;
    }

    public void printHist() {
        HistNode start = cur;
        while (start != null && start.prev != null) start = start.prev;
        HistNode p = start;
        System.out.print("History: ");
        while (p != null) {
            if (p == cur) System.out.print("[" + p.url + "]");
            else System.out.print(p.url);
            if (p.next != null) System.out.print(" <-> ");
            p = p.next;
        }
        System.out.println();
    }
}

