/*Arrays – Temperature Analyzer
Scenario: You're analyzing a week’s worth of hourly temperature data stored in a 2D array
(float[7][24]).
Problem:
Write a method to:
 ● Find the hottest and coldest day,
 ● Return average temperature per day. */

public class TempAnalyzer {

    static void analyze(float[][] t) {

        int hotDay = 0, coldDay = 0;
        float max = t[0][0], min = t[0][0];

        for (int d = 0; d < 7; d++) {
            float sum = 0;

            for (int h = 0; h < 24; h++) {
                sum += t[d][h];

                if (t[d][h] > max) {
                    max = t[d][h];
                    hotDay = d;
                }

                if (t[d][h] < min) {
                    min = t[d][h];
                    coldDay = d;
                }
            }

            float avg = sum / 24;
            System.out.println("Day " + (d + 1) + " average = " + avg);
        }

        System.out.println("Hottest Day = Day " + (hotDay + 1));
        System.out.println("Coldest Day = Day " + (coldDay + 1));
    }

    public static void main(String[] args) {

        float[][] temp = new float[7][24];

        // sample data
        for (int i = 0; i < 7; i++) {
            for (int j = 0; j < 24; j++) {
                temp[i][j] = 20 + i + j % 5;
            }
        }

        analyze(temp);
    }
}
