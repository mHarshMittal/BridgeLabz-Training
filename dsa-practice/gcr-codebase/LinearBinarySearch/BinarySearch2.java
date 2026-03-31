public class BinarySearch2 {
    public static int findPeakElement(int[] arr) {
        int left = 0;
        int right = arr.length - 1;
        
        while (left < right) {
            int mid = left + (right - left) / 2;
            boolean isLeftGreater = (mid > 0 && arr[mid - 1] > arr[mid]);
            boolean isRightGreater = (mid < arr.length - 1 && arr[mid + 1] > arr[mid]);
            
            if (!isLeftGreater && !isRightGreater) {
                return mid;
            } else if (isLeftGreater) {
                right = mid - 1;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }
    
    public static void main(String[] args) {
        int[] test1 = {1, 2, 3, 1};
        int[] test2 = {1, 2, 1, 3, 5, 6, 4};
        int[] test3 = {1, 2, 3, 4, 5};
        
        System.out.println("Array: [1, 2, 3, 1]");
        int result1 = findPeakElement(test1);
        System.out.println("Peak index: " + result1);
        System.out.println("Peak value: " + test1[result1]);
        System.out.println();
        
        System.out.println("Array: [1, 2, 1, 3, 5, 6, 4]");
        int result2 = findPeakElement(test2);
        System.out.println("Peak index: " + result2);
        System.out.println("Peak value: " + test2[result2]);
        System.out.println();
        
        System.out.println("Array: [1, 2, 3, 4, 5]");
        int result3 = findPeakElement(test3);
        System.out.println("Peak index: " + result3);
        System.out.println("Peak value: " + test3[result3]);
    }
}
