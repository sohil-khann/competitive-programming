


import java.util.ArrayList;
import java.util.List;
import java.util.Collections;

public class Bubblesort { 
	public static void main(String[] args) {
	  int arr[]={44,77,22,99,11};
	  int i,j,temp;
	  System.out.println("Before sorting array is ");
	   for(i=0;i<arr.length;i++)
	   System.out.print(arr[i]+" ");
	  
	  for(i=0;i<arr.length-1;i++)
	  {
	      for(j=0;j<arr.length-1-i;j++)
	      {
	          if(arr[j]>arr[j+1])
	          {
	        	  temp=arr[j];
		          arr[j]=arr[j+1];
		          arr[j+1]=temp;
	          }
	      }
	  }
	   System.out.println();
	   System.out.println("After sorting array is ");
	   for(i=0;i<arr.length;i++)
	   System.out.print(arr[i]+" ");
	   
	}
}


