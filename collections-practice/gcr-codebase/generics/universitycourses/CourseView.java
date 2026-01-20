import java.util.List;

public final class CourseView {
    private CourseView() {}

    public static void printAll(List<? extends CourseType> list) {
        for (CourseType ct : list) {
            System.out.println(ct);
        }
    }
}

