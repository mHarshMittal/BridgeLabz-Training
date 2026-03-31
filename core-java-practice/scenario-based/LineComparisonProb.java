
/*Start with Displaying
Welcome to Line
Comparison Computation
Program 

START

As a fan of geometry, I want to
model a line based on a point
consisting of (x, y) co-ordinates
using the Cartesian system,
So that I can calculate its length
- A Length as 2 Points (x1, y1) and (x2, y2) - Length of a Line = sqrt( (x2 - x1) ^ 2 + (y2- y1) ^ 2)

UC 1

As a fan of geometry, I want to
check equality of two lines
based on the end points, So
that I know when two lines are
the equal.- Using Java equals method to check equality of 2 Lengths is preferable.

UC 2

As a fan of geometry, I want to
compare two lines based on
the end points, So that I know
one line is equal, greater or
less than the other line. - Using Java compareTo method to compare 2 Lengths is
preferable.
*/

import java.util.*;
public class LineComparisonProb {
    public static void main(String[] args) {
        System.out.println("Welcome to Line Comparison Computation Program");

        // UC1: Calculate length of two lines, take inpur from user
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter coordinates for Line 1 (x1 y1 x2 y2): ");
        double x1 = sc.nextDouble();
        double y1 = sc.nextDouble();
        double x2 = sc.nextDouble();
        double y2 = sc.nextDouble();

        System.out.println("Enter coordinates for Line 2 (a1 b1 a2 b2): ");
        double a1 = sc.nextDouble();
        double b1 = sc.nextDouble();
        double a2 = sc.nextDouble();
        double b2 = sc.nextDouble();

        double length1 = Math.sqrt(Math.pow(x2 - x1, 2) + Math.pow(y2 - y1, 2));
        double length2 = Math.sqrt(Math.pow(a2 - a1, 2) + Math.pow(b2 - b1, 2));

        System.out.println("Length of Line1 = " + length1);
        System.out.println("Length of Line2 = " + length2);

        // UC1: Check equality using equals method as given in the question
        Double d1 = length1;
        Double d2 = length2;

        if (d1.equals(d2)) {
            System.out.println("Line1 and Line2 are equal in length.");
        } else {
            System.out.println("Line1 and Line2 are NOT equal in length.");
        }

        // UC2: Compare lines
        if (length1 > length2) {
            System.out.println("Line1 is longer than Line2.");
        } else if (length1 < length2) {
            System.out.println("Line1 is shorter than Line2.");
        } else {
            System.out.println("Line1 and Line2 are equal.");
        }
        sc.close();
    }
}
