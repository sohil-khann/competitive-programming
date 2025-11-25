package cryptography;
public class VigenereCipher {
    // Encrypt: lowercase -> uppercase using a keyword
    public static String encrypt(String plain, String key) {
        key = key.toUpperCase();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            char k = key.charAt(i % key.length());
            int p = plain.charAt(i) - 'a';
            int c = (p + (k - 'A')) % 26;
            out.append((char) ('A' + c));
        }
        return out.toString();
    }

    // Decrypt: uppercase -> lowercase
    public static String decrypt(String cipher, String key) {
        key = key.toUpperCase();
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < cipher.length(); i++) {
            char k = key.charAt(i % key.length());
            int c = cipher.charAt(i) - 'A';
            int p = (c - (k - 'A') + 26) % 26;
            out.append((char) ('a' + p));
        }
        return out.toString();
    }

    // Brute-force: try single-letter keys (0..25) and print all
    public static void bruteForce(String cipher) {
        for (int k = 0; k < 26; k++) {
            StringBuilder out = new StringBuilder();
            for (char ch : cipher.toCharArray()) {
                int c = ch - 'A';
                int p = (c - k + 26) % 26;
                out.append((char) ('a' + p));
            }
            System.out.println("Key " + k + ": " + out);
        }
    }

    // Quick demo
    public static void main(String[] args) {
        String plain = "meetmeaftertogaparty";
        String key = "KEY";
        String cipher = encrypt(plain, key);
        String back = decrypt(cipher, key);
        System.out.println("Plain:  " + plain);
        System.out.println("Cipher: " + cipher);
        System.out.println("Back:   " + back);
        System.out.println("\nBrute-force (single-letter keys):");
        bruteForce(cipher);
    }
}

