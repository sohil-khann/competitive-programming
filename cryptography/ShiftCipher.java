package cryptography;
public class ShiftCipher {
    // Encrypt: lowercase only -> uppercase only
    public static String encrypt(String plain, int key) {
        StringBuilder out = new StringBuilder();
        key = (key % 26 + 26) % 26; // safe positive key
        for (char ch : plain.toCharArray()) {
            int p = ch - 'a';
            int c = (p + key) % 26;
            out.append((char) ('A' + c));
        }
        return out.toString();
    }

    // Decrypt: uppercase only -> lowercase only
    public static String decrypt(String cipher, int key) {
        StringBuilder out = new StringBuilder();
        key = (key % 26 + 26) % 26;
        for (char ch : cipher.toCharArray()) {
            int c = ch - 'A';
            int p = (c - key + 26) % 26;
            out.append((char) ('a' + p));
        }
        return out.toString();
    }

    // Try every key (0-25) and print results
    public static void bruteForce(String cipher) {
        for (int k = 0; k < 26; k++) {
            System.out.println("Key " + k + ": " + decrypt(cipher, k));
        }
    }

    // Quick demo
    public static void main(String[] args) {
        String plain = "hello";
        int key = 3;
        String cipher = encrypt(plain, key);
        String back = decrypt(cipher, key);
        System.out.println("Plain:  " + plain);
        System.out.println("Cipher: " + cipher);
        System.out.println("Back:   " + back);
        System.out.println("\nBrute-force:");
        bruteForce(cipher);
    }
}

