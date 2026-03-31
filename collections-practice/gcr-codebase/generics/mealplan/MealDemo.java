public class MealDemo {
    public static void main(String[] args) {
        Meal<VegetarianMeal> m1 = MealFactory.create("Rohan", new VegetarianMeal());
        Meal<VeganMeal> m2 = MealFactory.create("Sara", new VeganMeal());
        Meal<KetoMeal> m3 = MealFactory.create("Jay", new KetoMeal());

        System.out.println(m1);
        System.out.println(m2);
        System.out.println(m3);
    }
}

