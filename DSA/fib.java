import java.util.Scanner;

public class fib {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter the value of n: ");
        int n = scanner.nextInt();
        
        System.out.println(fibonacciDP(n));

    }

    public static int fibonacciDP(int n) {
        if (n <= 1) {
            return n;
        }
        int a=0;


        int[] dp = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;
  
  

        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
            

        }

        return dp[n];
    }
}