import java.util.Scanner;

public class AffineCipher {

    public static boolean isCoprime(int a) {
        return gcd(a, 26) == 1;
    }

    public static int gcd(int a, int b) {
        return b == 0 ? a : gcd(b, a % b);
    }

    public static int modInverse(int a) {
        for (int i = 1; i < 26; i++) {
            if ((a * i) % 26 == 1) return i;
        }
        return -1;
    }

    public static boolean isValidPlaintext(String text) {
        return text.matches("[a-z]+");
    }

    public static boolean isValidCiphertext(String text) {
        return text.matches("[A-Z]+");
    }

    public static String encrypt(String plaintext, int a, int b) {
        StringBuilder cipher = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            int x = ch - 'a';
            int enc = (a * x + b) % 26;
            cipher.append((char) (enc + 'A'));
        }
        return cipher.toString();
    }

    public static String decrypt(String ciphertext, int a, int b) {
        int a_inv = modInverse(a);
        if (a_inv == -1) throw new IllegalArgumentException("No modular inverse for a = " + a);

        StringBuilder plain = new StringBuilder();
        for (char ch : ciphertext.toCharArray()) {
            int y = ch - 'A';
            int dec = (a_inv * (y - b + 26)) % 26;
            plain.append((char) (dec + 'a'));
        }
        return plain.toString();
    }

    public static void bruteForce(String ciphertext) {
        System.out.println("Brute Force Results:");
        for (int a = 1; a < 26; a++) {
            if (!isCoprime(a)) continue;
            for (int b = 0; b < 26; b++) {
                String decrypted = decrypt(ciphertext, a, b);
                System.out.println("a = " + a + ", b = " + b + " → " + decrypted);
            }
        }
    }

    public static int readIntInRange(Scanner sc, String prompt, int min, int max) {
        int val;
        while (true) {
            System.out.print(prompt);
            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter an integer.");
                sc.nextLine();
                continue;
            }
            val = sc.nextInt();
            sc.nextLine(); // consume newline
            if (val < min || val > max) {
                System.out.println("Value must be between " + min + " and " + max + ".");
                continue;
            }
            return val;
        }
    }

    public static int readCoprimeA(Scanner sc) {
        int a;
        while (true) {
            a = readIntInRange(sc, "Enter key 'a' (coprime with 26): ", 1, 25);
            if (!isCoprime(a)) {
                System.out.println("Key 'a' must be coprime with 26. Try again.");
                continue;
            }
            return a;
        }
    }

    public static int readB(Scanner sc) {
        return readIntInRange(sc, "Enter key 'b' (0–25): ", 0, 25);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice = 0;

        while (true) {
            System.out.println("\n===== Affine Cipher Menu =====");
            System.out.println("1. Encrypt");
            System.out.println("2. Decrypt");
           // System.out.println("3. Brute Force");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            if (!sc.hasNextInt()) {
                System.out.println("Invalid input. Please enter a number between 1–4.");
                sc.nextLine();
                continue;
            }

            choice = sc.nextInt();
            sc.nextLine(); // consume newline

            if (choice == 4) {
                System.out.println("Programme ended.");
                break;
            }

            switch (choice) {
                case 1:
                    // keep asking plaintext until valid (won't go back to menu)
                    String plaintext;
                    while (true) {
                        System.out.print("Enter plaintext (lowercase only): ");
                        plaintext = sc.nextLine().trim();
                        if (!isValidPlaintext(plaintext)) {
                            System.out.println("Invalid input. Only lowercase letters allowed. Please try again.");
                            continue;
                        }
                        break;
                    }

                    int a1 = readCoprimeA(sc);
                    int b1 = readB(sc);

                    String encrypted = encrypt(plaintext, a1, b1);
                    System.out.println("Encrypted Text: " + encrypted);
                    break;

                case 2:

                    String ciphertext;
                    while (true) {
                        System.out.print("Enter ciphertext (UPPERCASE only): ");
                        ciphertext = sc.nextLine().trim();
                        if (!isValidCiphertext(ciphertext)) {
                            System.out.println("Invalid input. Only uppercase letters allowed. Please try again.");
                            continue;
                        }
                        break;
                    }

                    int a2 = readCoprimeA(sc);
                    int b2 = readB(sc);

                    try {
                        String decrypted = decrypt(ciphertext, a2, b2);
                        System.out.println("Decrypted Text: " + decrypted);
                    } catch (Exception e) {
                        System.out.println("Error during decryption: " + e.getMessage());
                    }
                    break;

//                case 3:
//                    // brute force input loop
//                    String bruteText;
//                    while (true) {
//                        System.out.print("Enter ciphertext (UPPERCASE only): ");
//                        bruteText = sc.nextLine().trim();
//                        if (!isValidCiphertext(bruteText)) {
//                            System.out.println("Invalid input. Only uppercase letters allowed. Please try again.");
//                            continue;
//                        }
//                        break;
//                    }
//                    bruteForce(bruteText);
//                    break;

                default:
                    System.out.println("Invalid choice. Please select a number between 1–4.");
            }
        }

        sc.close();
    }
}
