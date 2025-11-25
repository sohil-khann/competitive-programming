package cryptography;
public class AffineCipher {
    // Encrypt: lowercase -> uppercase; a must be coprime with 26
    public static String encrypt(String plain, int a, int b) {
        if (gcd(a, 26) != 1) throw new IllegalArgumentException("a must be coprime with 26");
        StringBuilder out = new StringBuilder();
        a = (a % 26 + 26) % 26;
        b = (b % 26 + 26) % 26;
        for (char ch : plain.toCharArray()) {
            int p = ch - 'a';
            int c = (a * p + b) % 26;
            out.append((char) ('A' + c));
        }
        return out.toString();
    }

    // Decrypt: uppercase -> lowercase
    public static String decrypt(String cipher, int a, int b) {
        if (gcd(a, 26) != 1) throw new IllegalArgumentException("a must be coprime with 26");
        int inv = modInverse(a, 26);
        b = (b % 26 + 26) % 26;
        StringBuilder out = new StringBuilder();
        for (char ch : cipher.toCharArray()) {
            int c = ch - 'A';
            int p = (inv * (c - b + 26)) % 26;
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

    // Brute-force: try all valid (a,b) pairs and print first 5
    public static void bruteForce(String cipher) {
        int count = 0;
        for (int a = 1; a < 26; a++) {
            if (gcd(a, 26) != 1) continue;
            for (int b = 0; b < 26; b++) {
                System.out.println("a=" + a + " b=" + b + ": " + decrypt(cipher, a, b));
                if (++count >= 5) return; // show first 5 only
            }
        }
    }

    // Quick demo
    public static void main(String[] args) {
        String plain = "affine";
        int a = 5, b = 8;
        String cipher = encrypt(plain, a, b);
        String back = decrypt(cipher, a, b);
        System.out.println("Plain:  " + plain);
        System.out.println("Cipher: " + cipher);
        System.out.println("Back:   " + back);
        System.out.println("\nBrute-force (first 5):");
        bruteForce(cipher);
    }
}
