/*
* Rohan’s Library Reminder App 📚
Rohan wants a fine calculator:
● Input return date and due date.
● If returned late, calculate fine: ₹5/day.
● Repeat for 5 books using for-loop

*/

import java.util.Scanner;

public class Library {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int finePerDay = 5;

        for (int book = 1; book <= 5; book++) {

            System.out.println("Book " + book);

            System.out.print("Enter due date (dd mm yyyy): ");
            System.out.println("Enter the Day");

            int dueDay = sc.nextInt();
            System.out.println("Enter the Month");

            int dueMonth = sc.nextInt();
            System.out.println("Enter the Year");
            int dueYear = sc.nextInt();

            System.out.print("Enter return date (dd mm yyyy): ");
            System.out.println("Enter the Day");

            int returnDay = sc.nextInt();
            System.out.println("Enter the Month");
            int returnMonth = sc.nextInt();
            System.out.println("Enter the Year");
            int returnYear = sc.nextInt();

            int dueTotalDays = dueYear * 365 + dueMonth * 30 + dueDay;
            int returnTotalDays = returnYear * 365 + returnMonth * 30 + returnDay;

            if (returnTotalDays > dueTotalDays) {
                int lateDays = returnTotalDays - dueTotalDays;
                int fine = lateDays * finePerDay;
                System.out.println("Late by " + lateDays + " days, Fine = Rs/- " + fine);
            } else {
                System.out.println("Returned on time, No fine");
            }

            System.out.println("---------------------------");
        }

        sc.close();
    }
}
