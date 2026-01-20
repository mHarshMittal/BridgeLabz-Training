import java.util.Arrays;
import java.util.List;

public class ResumeDemo {
    public static void main(String[] args) {
        Resume<SoftwareEngineerRole> r1 =
                new Resume<>("Ankit", new SoftwareEngineerRole(), 82.5);
        Resume<DataScientistRole> r2 =
                new Resume<>("Meera", new DataScientistRole(), 90.0);
        Resume<ProductManagerRole> r3 =
                new Resume<>("Rahul", new ProductManagerRole(), 75.0);

        System.out.println(r1);
        System.out.println(r2);
        System.out.println(r3);

        List<? extends JobRole> roles = Arrays.asList(
                r1.getRole(), r2.getRole(), r3.getRole()
        );
        ResumeUtil.printPipeline(roles);
    }
}

