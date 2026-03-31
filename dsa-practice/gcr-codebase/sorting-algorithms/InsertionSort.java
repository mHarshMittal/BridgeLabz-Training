/* 
Insertion Sort - Sort Employee IDs
Problem Statement:
A company stores employee IDs in an unsorted array. Implement Insertion Sort to sort the employee IDs in ascending order.
Hint:
Divide the array into sorted and unsorted parts.
Pick an element from the unsorted part and insert it into its correct position in the sorted part.
Repeat for all elements.

*/

class InsertionSort {

    public static void main(String[] args) {
        int[] employeeIds = {104, 101, 109, 102, 105};

        // Insertion Sort logic
        for (int i = 1; i < employeeIds.length; i++) {
            int currentId = employeeIds[i];
            int j = i - 1;

            while (j >= 0 && employeeIds[j] > currentId) {
                employeeIds[j + 1] = employeeIds[j];
                j--;
            }
            employeeIds[j + 1] = currentId;
        }

        System.out.println("Sorted Employee IDs:");
        for (int id : employeeIds) {
            System.out.print(id + " ");
        }
    }
}

