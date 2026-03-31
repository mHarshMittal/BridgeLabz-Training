
public class Resume<T extends JobRole> {
    private final String name;
    private final T role;
    private final double score;

    public Resume(String name, T role, double score) {
        this.name = name;
        this.role = role;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public T getRole() {
        return role;
    }

    public double getScore() {
        return score;
    }

    @Override
    public String toString() {
        return name + " -> " + role.getTitle() + " score=" + score;
    }
}

