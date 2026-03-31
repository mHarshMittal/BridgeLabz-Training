import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class EduResultsDemo {
    public static void main(String[] args) {
        List<Student> districtA = new ArrayList<>();
        districtA.add(new Student("Asha", "North", 98));
        districtA.add(new Student("Rahul", "North", 92));
        districtA.add(new Student("Agraj", "North", 86));

        List<Student> districtB = new ArrayList<>();
        districtB.add(new Student("Kiran", "South", 96));
        districtB.add(new Student("Manoj", "South", 92));
        districtB.add(new Student("Mukul", "South", 88));

        List<Student> districtC = new ArrayList<>();
        districtC.add(new Student("Harsh", "East", 99));
        districtC.add(new Student("Nikhil", "East", 97));
        districtC.add(new Student("Shubh", "East", 92));

        List<Student> combined = new ArrayList<>();
        combined.addAll(districtA);
        combined.addAll(districtB);
        combined.addAll(districtC);

        Comparator<Student> byScoreDescending = Comparator
                .comparingInt(Student::getScore)
                .reversed()
                .thenComparing(Student::getName); // deterministic for ties

        MergeSorter sorter = new MergeSorter(byScoreDescending);
        List<Student> ranked = sorter.mergeSort(combined);

        System.out.println("State-wise rank list:");
        int rank = 1;
        for (Student s : ranked) {
            System.out.printf("#%d %s%n", rank++, s);
        }
    }
}
