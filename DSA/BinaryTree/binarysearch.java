package BinaryTree;

import java.util.Arrays;

public class binarysearch {
	  static void binarySearch(int arr[],int key)
	    {
	        int l=0,mid = 0;
	        int r=arr.length-1;
	        int flag=0;
	        while(l<=r)
	        {
	              mid=(l+r)/2;
	             if(arr[mid]==key)
	             {
	                 flag=1;
	                 break;
	             }
	             if(arr[mid]>key)
	             
	                 r=mid-1;
	            
	             else
	             l=mid+1;
	             
	        }
	        if(flag==1)
	        	System.out.println("Yes found at :"+mid);
			else
			System.out.println("Not found");
	          }
	    
		public static void main(String[] args) {
		    int[] arr={22,44,55,66,66,77,88};
		    int k=88;
		    binarySearch(arr,k);
		   
			}

	

}
