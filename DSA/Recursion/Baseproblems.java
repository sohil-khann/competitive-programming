package Recursion;

public class Baseproblems {
 public static void main(String[] args) {

    // System.out.println(rec(6));
    // System.out.println(sumOfDigit(123456));
    // System.out.println(ReverseNum(123456));
    // System.out.println(pallindromNum(12211));
    System.out.println(countZeroes(200020011,0));

    
 }  
 
 public static int rec(int n){
if(n<=1){
    return 1;
}
return n*rec(n-1);
 }

 public static int sumOfDigit(int n){
if(n==0){
    return 0; 
}

int val= n%10;

return val+sumOfDigit(n/10);
}
static int sum =0;
public static int ReverseNum(int n){
    
    if(n==0){
        return 1;
    }
    int val=n%10;
    sum = sum*10 +val;
    ReverseNum(n/10);
    return sum ;
}

public static boolean pallindromNum(int num){
    if(num == ReverseNum(num)){ 
        return true;

    }
    return false; 
}
public static int countZeroes(int num, int count) {

    if (num == 0) {
        return count;
    }

    int rem = num % 10;
    if (rem == 0) {
        return countZeroes(num / 10, count + 1);
    }

    return countZeroes(num / 10, count);
}

 }

// you can solve the problem no. 1342 on leetcode.
