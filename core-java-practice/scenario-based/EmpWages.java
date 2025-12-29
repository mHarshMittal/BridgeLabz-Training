/*
    Start with Displaying Welcome to Employee Wage Computation Program on Master Branch
    Check Employee is Present or Absent - Use ((RANDOM)) for Attendance Check
    Calculate Daily Employee Wage 
    Assumme wage per hour is 20 and Full day hour is 8
    Add Part Time Employee and Wage
    Assume Part time Hour is 8
    Solving using Switch Case Statement
    Calculate Monthly Employee Wage Assume 20 Working Day per Month
    Calculate Wages till a condition of total working hours or days is reached for a month - Assume 100 hours and 20 days

solve this in java using simple approach
*/

public class EmpWages {

    // Constants
    static final int WAGE_PER_HOUR = 20;
    static final int FULL_DAY_HOURS = 8; 
    static final int PART_TIME_HOURS = 4;   // as given in ques but let me take part time as 4 hrs onlyc
    static final int MAX_WORKING_DAYS = 20;
    static final int MAX_WORKING_HOURS = 100;

    public static void main(String[] args) {
        System.out.println("Welcome to Employee Wage Computation Program");

        int totalWage = 0;
        int totalHours = 0;
        int totalDays = 0;

        while (totalDays < MAX_WORKING_DAYS && totalHours < MAX_WORKING_HOURS) {
            totalDays++;
            int dailyHours = getDailyHours();
            totalHours += dailyHours;
            int dailyWage = dailyHours * WAGE_PER_HOUR;
            totalWage += dailyWage;
            System.out.println("Day " + totalDays + ": Worked " + dailyHours + " hours, Earned: Rs/- " + dailyWage);
        }

        System.out.println("Total Wage for the month: Rs/- " + totalWage);
        System.out.println("Total Hours Worked: " + totalHours);
        System.out.println("Total Days Worked: " + totalDays);
    }

    // Method to get daily working hours based on attendance
    public static int getDailyHours() {
        int attendance = (int) (Math.random() * 3); // 0: Absent, 1: Full-time, 2: Part-time
        switch (attendance) {
            case 1:
                return FULL_DAY_HOURS; // Full-time
            case 2:
                return PART_TIME_HOURS; // Part-time
            default:
                return 0; // Absent
        }
    }
}