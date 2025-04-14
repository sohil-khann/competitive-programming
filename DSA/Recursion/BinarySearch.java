package Recursion;

public class BinarySearch {
    public static void main(String[] args) {
        
        int arr[] = new int[]{2, 4, 6, 7, 9};

        int i=0;
        int e=arr.length-1;
        int target = 7;
      System.out.println(binarySearchRecursive(arr, i, e, target));  

    }

    public static int binarySearchRecursive(int[] arr, int i, int e, int target){
        if (i > e) {
            return -1;
        }
        int m = i + (e - i) / 2;
        if(arr[m]==target){
            return m;
        }
       
        if(arr[m]<target){
            return binarySearchRecursive(arr, m+1, e, target);
        }
        if(arr[m]>target){
            return binarySearchRecursive(arr, i, m-1, target);
        }
        return -1;

    }

}
