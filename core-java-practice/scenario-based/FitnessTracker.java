/*Sandeep’s Fitness Challenge Tracker ️
Each day Sandeep completes a number of push-ups.
● Store counts for a week.
● Use for-each to calculate total and average.
● Use continue to skip rest days. 
take input of days of week from user ask to enter 7 dyas push ups count 
*/

import java.util.Scanner;

public class FitnessTracker {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int[] pushUps = new int[7];
        int totalPushUps = 0;
        int activeDays = 0;

        // input for 7 days
        for (int day = 0; day < 7; day++) {
            System.out.print("Day " + (day + 1) + " push-ups (0 for rest day): ");
            pushUps[day] = sc.nextInt();
        }

        // for-each loop to calculate total and average
        for (int dailyCount : pushUps) {

            if (dailyCount == 0) {
                continue; // skip rest day
            }

            totalPushUps += dailyCount;
            activeDays++;
        }

        double average = (activeDays == 0) ? 0 : (double) totalPushUps / activeDays;

        System.out.println("Total Push-ups = " + totalPushUps);
        System.out.println("Average Push-ups = " + average);

        sc.close();
    }
}
