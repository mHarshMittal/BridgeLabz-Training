public class BinarySearch1 {
    public static int findRotationPoint(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] > arr[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
    
    public static void main(String[] args) {
        int[] test1 = {4, 5, 6, 7, 0, 1, 2};
        int[] test2 = {3, 4, 5, 1, 2};
        int[] test3 = {1, 2, 3, 4, 5};
        
        System.out.println("Array: [4, 5, 6, 7, 0, 1, 2]");
        int result1 = findRotationPoint(test1);
        System.out.println("Rotation point index: " + result1);
        System.out.println("Value: " + test1[result1]);
        System.out.println();
        
        System.out.println("Array: [3, 4, 5, 1, 2]");
        int result2 = findRotationPoint(test2);
        System.out.println("Rotation point index: " + result2);
        System.out.println("Value: " + test2[result2]);
        System.out.println();
        
        System.out.println("Array: [1, 2, 3, 4, 5]");
        int result3 = findRotationPoint(test3);
        System.out.println("Rotation point index: " + result3);
        System.out.println("Value: " + test3[result3]);
    }
}
