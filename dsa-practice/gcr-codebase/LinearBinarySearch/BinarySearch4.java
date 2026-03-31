public class BinarySearch4 {
    public static int findFirst(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                right = mid - 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    public static int findLast(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;
        int result = -1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) {
                result = mid;
                left = mid + 1;
            } else if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return result;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 2, 2, 2, 3, 4, 5};
        int target = 2;
        
        System.out.println("Array: [1, 2, 2, 2, 3, 4, 5]");
        System.out.println("Target: " + target);
        
        int first = findFirst(arr, target);
        int last = findLast(arr, target);
        
        System.out.println("First occurrence: " + first);
        System.out.println("Last occurrence: " + last);
        System.out.println();
        
        int[] arr2 = {1, 2, 3, 4, 5};
        int target2 = 6;
        
        System.out.println("Array: [1, 2, 3, 4, 5]");
        System.out.println("Target: " + target2);
        
        int first2 = findFirst(arr2, target2);
        int last2 = findLast(arr2, target2);
        
        System.out.println("First occurrence: " + first2);
        System.out.println("Last occurrence: " + last2);
    }
}
