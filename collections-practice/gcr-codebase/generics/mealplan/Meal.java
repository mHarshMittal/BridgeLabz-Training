
public class Meal<T extends MealPlan> {
    private final String user;
    private final T plan;

    public Meal(String user, T plan) {
        this.user = user;
        this.plan = plan;
    }

    public String getUser() {
        return user;
    }

    public T getPlan() {
        return plan;
    }

    @Override
    public String toString() {
        return "Meal{" + user + " -> " + plan.getName() + "}";
    }
}

