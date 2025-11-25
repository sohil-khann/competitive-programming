import java.util.*;

public class CaesarCipher {

    // --- Encryption Method ---
    public static String encryption(String text, int key) {
        StringBuilder result = new StringBuilder();
        key = key % 26;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char shifted = (char) ((ch - 'a' + key) % 26 + 'A'); // cipher in CAPITAL
                result.append(shifted);
            }
        }
        return result.toString();
    }

    // --- Decryption Method ---
    public static String decryption(String text, int key) {
        StringBuilder result = new StringBuilder();
        key = key % 26;

        for (char ch : text.toCharArray()) {
            if (Character.isLetter(ch)) {
                char shifted = (char) ((ch - 'A' - key + 26) % 26 + 'a'); // plain text in small
                result.append(shifted);
            }
        }
        return result.toString();
    }

    // --- Main Program ---
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.print("\nEnter 1 for Encrypt, 2 for Decrypt, 3 to Exit: ");
            int choice = sc.nextInt();
            sc.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    String plainText;

                    // --- Validate plain text ---
                    while (true) {
                        System.out.print("Enter plain text (lowercase letters only): ");
                        plainText = sc.nextLine();

                        if (plainText.matches("[a-z]+")) {
                            break;
                        } else {
                            System.out.println("⚠ Invalid input! Use only lowercase letters (a–z). Try again.");
                        }
                    }

                    // --- Validate key ---
                    int key;
                    while (true) {
                        System.out.print("Enter key (between 2 and 26): ");
                        key = sc.nextInt();
                        sc.nextLine();

                        if (key >= 2 && key <= 26) {
                            break;
                        } else {
                            System.out.println("⚠ Invalid key! Please enter a number between 2 and 26.");
                        }
                    }

                    String cipher = encryption(plainText, key);
                    System.out.println("\nPlain Text : " + plainText);
                    System.out.println("Key        : " + key);
                    System.out.println("Cipher Text: " + cipher);
                    break;

                case 2:
                    // --- Decryption Option ---
                    String cipherText;
                    while (true) {
                        System.out.print("Enter cipher text (capital letters only): ");
                        cipherText = sc.nextLine();

                        if (cipherText.matches("[A-Z]+")) {
                            break;
                        } else {
                            System.out.println("⚠ Invalid input! Use only capital letters (A–Z). Try again.");
                        }
                    }

                    int decryptKey;
                    while (true) {
                        System.out.print("Enter key (between 2 and 26): ");
                        decryptKey = sc.nextInt();
                        sc.nextLine();

                        if (decryptKey >= 1 && decryptKey <= 26) {
                            break;
                        } else {
                            System.out.println("⚠ Invalid key! Please enter a number between 1 and 26.");
                        }
                    }

                    String decrypted = decryption(cipherText, decryptKey);
                    System.out.println("\nCipher Text: " + cipherText);
                    System.out.println("Key        : " + decryptKey);
                    System.out.println("Decrypted  : " + decrypted);
                    break;

                case 3:
                    System.out.println("Exiting...");
                    running = false;
                    break;

                default:
                    System.out.println("Invalid choice! Please enter 1, 2, or 3.");
            }
        }

        sc.close();
    }
}
//import java.util.Scanner;
//
//public class CaesarCipher {
//
//    public static String encryption(String text, int key) {
//        StringBuilder result = new StringBuilder();
//        key = key % 26;
//
//        for (char ch : text.toCharArray()) {
//            if (Character.isLetter(ch)) {
//                if (Character.isUpperCase(ch)) {
//                    System.out.println("Warning: Input contains uppercase letters.");
//                    ch = Character.toLowerCase(ch);
//                }
//                char shifted = (char) ((ch - 'a' + key) % 26 + 'A');
//                result.append(shifted);
//            } else {
//                result.append(Character.toUpperCase(ch));             }
//        }
//        return result.toString();
//    }
//
//    public static String decryption(String text, int key) {
//        StringBuilder result = new StringBuilder();
//        key = key % 26;
//
//        for (char ch : text.toCharArray()) {
//            if (Character.isLetter(ch)) {
//                char shifted = (char) ((ch - 'A' - key + 26) % 26 + 'A');
//                result.append(shifted);
//            } else {
//                result.append(Character.toUpperCase(ch));             }
//        }
//        return result.toString();
//    }
//
//    public static void main(String[] args) {
//        Scanner sc = new Scanner(System.in);
//
//        String text;
//        while (true) {
//            System.out.print("Enter text (lowercase only): ");
//            text = sc.nextLine();
//            if (!text.equals(text.toLowerCase())) {
//                System.out.println(" Warning: Input contains uppercase letters.");
//            } else {
//                break;
//            }
//        }
//
//        System.out.print("Enter key (0–25): ");
//        int key = sc.nextInt();
//        key = key % 26;
//
//        boolean running = true;
//        while (running) {
//            System.out.print("\nEnter 1 for Encrypt, 2 for Decrypt, 3 to Exit: ");
//            int choice = sc.nextInt();
//            sc.nextLine();
//
//            switch (choice) {
//                case 1:
//                    System.out.println("Plain Text: " + text.toUpperCase());
//                    String encrypted = encryption(text, key);
//                    System.out.println("Cipher Text: " + encrypted);
//                    break;
//                case 2:
//                    String encryptedText = encryption(text, key);
//                    String decrypted = decryption(encryptedText, key);
//                    System.out.println("Decrypted Text: " + decrypted);
//                    break;
//                case 3:
//                    running = false;
//                    System.out.println("Exiting...");
//                    break;
//                default:
//                    System.out.println("Invalid choice. Please enter 1, 2, or 3.");
//            }
//        }
//
//        sc.close();
//    }
//}