
public final class MealFactory {
    private MealFactory() {}

    public static <T extends MealPlan> Meal<T> create(String user, T plan) {
        if (user == null || user.isEmpty()) {
            throw new IllegalArgumentException("user required");
        }
        if (plan == null) {
            throw new IllegalArgumentException("plan required");
        }
        return new Meal<>(user, plan);
    }
}

