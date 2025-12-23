import java.util.Random;

public class StudentGrade {
    public static void main(String[] args) {
        Random random = new Random();
        int[][] mark = new int[5][3];

        System.out.println("Phy\tChem\tMath\tTotal\t%\tGrade");
        for (int i = 0; i < 5; i++) {
            int total = 0;
            for (int j = 0; j < 3; j++) {
                mark[i][j] = random.nextInt(41) + 60;
                total += mark[i][j];
            }
            double percent = total / 3.0;
            String grade = percent >= 90 ? "A+" : percent >= 80 ? "A" : percent >= 70 ? "B" : percent >= 60 ? "C" : "D";

            System.out.printf("%d\t%d\t%d\t%d\t%.2f\t%s\n", mark[i][0], mark[i][1], mark[i][2], total, percent, grade);
        }
    }
}
