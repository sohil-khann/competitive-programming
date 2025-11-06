import java.util.Scanner;

public class MultiplicativeCipher {

    public static String encrypt(String message, int key) {
        StringBuilder encrypted = new StringBuilder();
        message = message.toUpperCase();

        for (char ch : message.toCharArray()) {
            if (Character.isLetter(ch)) {

                int x = ch - 'A';
                int enc = (x * key) % 26;

                encrypted.append((char) (enc + 'A'));
            } else {
                encrypted.append(ch);
            }
        }
        return encrypted.toString();
    }

    public static String decrypt(String encrypted, int key) {
        StringBuilder decrypted = new StringBuilder();

        encrypted = encrypted.toUpperCase();

        int inverseKey = modInverse(key, 26);
        if (inverseKey == -1) {
            System.out.print("key has no modular inverse ");
        }

        for (char ch : encrypted.toCharArray()) {
            if (Character.isLetter(ch)) {

                int y = ch - 'A';

                int dec = (y * inverseKey) % 26;

                decrypted.append((char) (dec + 'A'));
            } else {

                decrypted.append(ch);

            }
        }
        return decrypted.toString();
    }

    public static int modInverse(int key, int mod) {
        for (int i = 1; i < mod; i++) {
            if ((key * i) % mod == 1) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.print("Enter plain text : ");
        String message = sc.nextLine();

        System.out.print("Enter key : ");
        int key = sc.nextInt();

        String encrypted = encrypt(message, key);

        System.out.println("Encrypted: " + encrypted);

        String decrypted = decrypt(encrypted, key);

        System.out.println("Decrypted: " + decrypted);
    }
}