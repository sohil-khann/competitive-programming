package cryptography;
public class MultiplicativeCipher {
    // Encrypt: lowercase -> uppercase; key must be coprime with 26
    public static String encrypt(String plain, int key) {
        if (gcd(key, 26) != 1) throw new IllegalArgumentException("key must be coprime with 26");
        StringBuilder out = new StringBuilder();
        for (char ch : plain.toCharArray()) {
            int p = ch - 'a';
            int c = (p * key) % 26;
            out.append((char) ('A' + c));
        }
        return out.toString();
    }

    // Decrypt: uppercase -> lowercase
    public static String decrypt(String cipher, int key) {
        if (gcd(key, 26) != 1) throw new IllegalArgumentException("key must be coprime with 26");
        int inv = modInverse(key, 26);
        StringBuilder out = new StringBuilder();
        for (char ch : cipher.toCharArray()) {
            int c = ch - 'A';
            int p = (c * inv) % 26;
            out.append((char) ('a' + p));
        }
        return out.toString();
    }

    // Helper: gcd
    private static int gcd(int a, int b) {
        while (b != 0) { int t = a % b; a = b; b = t; }
        return Math.abs(a);
    }

    // Helper: modular inverse
    private static int modInverse(int a, int m) {
        a = (a % m + m) % m;
        for (int x = 1; x < m; x++) if ((a * x) % m == 1) return x;
        throw new IllegalArgumentException("no inverse");
    }

    // Brute-force: try all coprime keys and print results
    public static void bruteForce(String cipher) {
        for (int k = 1; k < 26; k++) {
            if (gcd(k, 26) != 1) continue;
            System.out.println("Key " + k + ": " + decrypt(cipher, k));
        }
    }

    // Quick demo
    public static void main(String[] args) {
        String plain = "hello";
        int key = 5;
        String cipher = encrypt(plain, key);
        String back = decrypt(cipher, key);
        System.out.println("Plain:  " + plain);
        System.out.println("Cipher: " + cipher);
        System.out.println("Back:   " + back);
        System.out.println("\nBrute-force:");
        bruteForce(cipher);
    }
}

