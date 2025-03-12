

import java.util.Scanner;

public class sumOfRoundNumbers_1352A {
public static int  sum(int num){
    int[] t1={10,100,1000,10000};
    for (int i : t1) {
        if (num%i!=0) {
            num-=num%i;
            System.out.println(num);
        }
        
    }
    return 0;
}
public static void main(String[] args) {
    
    Scanner sc=new Scanner(System.in);
    int testCases=sc.nextInt();
    
    int arr[]=new int[testCases];
    for (int i = 0; i < testCases; i++) {
        int num=sc.nextInt();

        sum(num);
    }
}

 }

 