import java.util.List;


public final class ResumeUtil {
    private ResumeUtil() {}

    public static void printPipeline(List<? extends JobRole> roles) {
        System.out.println("Pipeline roles:");
        for (JobRole r : roles) {
            System.out.println(" - " + r);
        }
    }
}

