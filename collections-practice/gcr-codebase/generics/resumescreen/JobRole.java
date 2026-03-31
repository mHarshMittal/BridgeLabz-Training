
public abstract class JobRole {
    private final String title;

    protected JobRole(String title) {
        this.title = title;
    }

    public String getTitle() {
        return title;
    }

    @Override
    public String toString() {
        return getClass().getSimpleName() + "(" + title + ")";
    }
}

