package sorting;
import java.util.Scanner;


	public class InsertionSort {

	    public static void main(String[] args) {
	        int[] a = {2, 4, 987, 23, 54, 65};
	        int i, j, item;
	        // The loop should start from 1 since the first element is considered sorted
	        for (i = 1; i < a.length; i++) {
	            item = a[i];
	            j = i - 1;
	            // The condition should check if a[j] is greater than item
	            while (j >= 0 && a[j] > item) {
	                a[j + 1] = a[j];
	                j = j - 1;
	            }
	            a[j + 1] = item;
	        }
	        
	        for (int k = 0; k < a.length; k++) {
	            System.out.print("  "+a[k]);
	        }
	    }
	}


