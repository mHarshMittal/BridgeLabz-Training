
import java.util.*;

class Student {
	String name;
	String department;
	int[] quizzes;

	Student(String name, String department, int q1, int q2, int q3) {
		this.name = name;
		this.department = department;
		this.quizzes = new int[] { q1, q2, q3 };
	}

	int totalScore() {
		return quizzes[0] + quizzes[1] + quizzes[2];
	}
}

public class QuizPerformanceRankingSystem {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = Integer.parseInt(sc.nextLine());
		List<Student> students = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			String line = sc.nextLine();
			String[] parts = line.split(" ");
			if (parts[0].equals("Record")) {
				String name = parts[1];
				String department = parts[2];
				int q1 = Integer.parseInt(parts[3]);
				int q2 = Integer.parseInt(parts[4]);
				int q3 = Integer.parseInt(parts[5]);
				students.add(new Student(name, department, q1, q2, q3));
				System.out.println("Record Added: " + name);
			} else if (parts[0].equals("Top")) {
				String target = parts[1];
				if (target.equals("Q1") || target.equals("Q2") || target.equals("Q3")) {
					int quizIndex = target.equals("Q1") ? 0 : (target.equals("Q2") ? 1 : 2);
					if (students.isEmpty()) {
						System.out.println("No Records Available");
						continue;
					}
					int maxScore = Integer.MIN_VALUE;
					for (Student s : students) {
						maxScore = Math.max(maxScore, s.quizzes[quizIndex]);
					}
					for (Student s : students) {
						if (s.quizzes[quizIndex] == maxScore) {
							System.out.println(s.name + " " + maxScore);
						}
					}
				} else {
					List<Student> deptStudents = new ArrayList<>();
					for (Student s : students) {
						if (s.department.equals(target)) {
							deptStudents.add(s);
						}
					}
					if (deptStudents.isEmpty()) {
						System.out.println("Department Not Found");
						continue;
					}
					int maxTotal = Integer.MIN_VALUE;
					for (Student s : deptStudents) {
						maxTotal = Math.max(maxTotal, s.totalScore());
					}
					for (Student s : deptStudents) {
						if (s.totalScore() == maxTotal) {
							System.out.println(s.name + " " + s.totalScore());
						}
					}
				}
			}
		}
		sc.close();
	}
}