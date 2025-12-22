//crete an array and u have to add 1 to last element of that array  and if sum become 10 for last element then increase the size of array by 1 
public class ArrayProg{
    public static void main(String[] args){
        int arr[] = {1, 2, 3, 4, 9};
        int lastEle = arr[arr.length - 1];
        if (lastEle == 9) {
            // create new array if sum is 10
            int[] newArray = new int[arr.length + 1];
            for (int i = 0; i < arr.length; i++) {
                newArray[i] = arr[i];
                
            }
            newArray[newArray.length - 1] = 0; 
            System.out.println( newArray.length);
        } else {
            
            arr[arr.length - 1] = lastEle + 1;
            System.out.println(arr[arr.length - 1]);

        }
    }
}