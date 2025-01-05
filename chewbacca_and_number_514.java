public class chewbacca_and_number_514 {

    public static void main(String[] args) {
        java.util.Scanner sc = new java.util.Scanner(System.in);
        String s = sc.next();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < s.length(); i++) {
            int digit = s.charAt(i) - '0';
            if (digit >= 5) {
                if (digit == 9 && i == 0) {
                    sb.append(digit);
                } else {
                    sb.append(9 - digit);
                }
            } else {
                sb.append(digit);
            }
        }
        System.out.println(sb);
        sc.close();

       }
}