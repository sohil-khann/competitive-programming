package sorting;

public class selectiosort {

    static void selectionSort(int[]  a)
    { int i,j,temp,min;
     System.out.println("After sorting array is ");
	 for(i=0;i<a.length;i++)
	 System.out.print(a[i]+" ");
    for(i=0;i<a.length-1;i++)
    {
        min=i;
        for(j=i+1;j<a.length;j++)
        {
            if(a[min]>a[j])
            min=j;
        }
        temp=a[i];
        a[i]=a[min];
        a[min]=temp;
    }
       System.out.println();
	   System.out.println("After sorting array is ");
	   for(i=0;i<a.length;i++)
	   System.out.print(a[i]+" ");
    }
	public static void main(String[] args) {
	  int a[]={44,77,22,99,11};
	  selectionSort(a);
	}

}
