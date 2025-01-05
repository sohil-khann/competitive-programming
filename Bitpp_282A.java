public class Bitpp_282A {
    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        int n = sc.nextInt();
        int x = 0;
        for (int i = 0; i < n; i++) {
            String s = sc.next();
            if (s.charAt(1) == '+') {
                x++;
            } else {
                x--;
            }
        }
        System.out.println(x);
        sc.close();
    }
    
}
