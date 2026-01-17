public class LinearSearch1 {
    public static int findFirstNegative(int[] arr) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < 0) {
                return i;
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, -4, 5, 6};
        int[] test2 = {1, 2, 3, 4, 5};
        int[] test3 = {-1, -2, -3};
        
        System.out.println("Array: [1, 2, 3, -4, 5, 6]");
        int result1 = findFirstNegative(test1);
        System.out.println("First negative at index: " + result1);
        if (result1 != -1) {
            System.out.println("Value: " + test1[result1]);
        }
        System.out.println();
        
        System.out.println("Array: [1, 2, 3, 4, 5]");
        int result2 = findFirstNegative(test2);
        System.out.println("First negative at index: " + result2);
        System.out.println();
        
        System.out.println("Array: [-1, -2, -3]");
        int result3 = findFirstNegative(test3);
        System.out.println("First negative at index: " + result3);
        if (result3 != -1) {
            System.out.println("Value: " + test3[result3]);
        }
    }
}
