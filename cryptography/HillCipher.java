package cryptography;
public class HillCipher {
    // Encrypt: lowercase -> uppercase using 2x2 key matrix
    public static String encrypt(String plain, int[][] key) {
        StringBuilder out = new StringBuilder();
        plain = (plain.length() % 2 == 0) ? plain : plain + "x";
        for (int i = 0; i < plain.length(); i += 2) {
            int x0 = plain.charAt(i) - 'a';
            int x1 = plain.charAt(i + 1) - 'a';
            int y0 = (key[0][0] * x0 + key[0][1] * x1) % 26;
            int y1 = (key[1][0] * x0 + key[1][1] * x1) % 26;
            out.append((char) ('A' + y0)).append((char) ('A' + y1));
        }
        return out.toString();
    }

    // Decrypt: uppercase -> lowercase
    public static String decrypt(String cipher, int[][] key) {
        int[][] inv = inverse2x2(key);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < cipher.length(); i += 2) {
            int y0 = cipher.charAt(i) - 'A';
            int y1 = cipher.charAt(i + 1) - 'A';
            int x0 = (inv[0][0] * y0 + inv[0][1] * y1) % 26;
            int x1 = (inv[1][0] * y0 + inv[1][1] * y1) % 26;
            out.append((char) ('a' + x0)).append((char) ('a' + x1));
        }
        return out.toString();
    }

    // Helpers
    private static int[][] inverse2x2(int[][] k) {
        int det = (k[0][0] * k[1][1] - k[0][1] * k[1][0]) % 26;
        det = (det < 0) ? det + 26 : det;
        int invDet = modInverse(det, 26);
        int[][] inv = new int[2][2];
        inv[0][0] = (k[1][1] * invDet) % 26;
        inv[0][1] = ((-k[0][1] + 26) % 26 * invDet) % 26;
        inv[1][0] = ((-k[1][0] + 26) % 26 * invDet) % 26;
        inv[1][1] = (k[0][0] * invDet) % 26;
        return inv;
    }

    private static int modInverse(int a, int m) {
        a = (a % m + m) % m;
        for (int x = 1; x < m; x++) if ((a * x) % m == 1) return x;
        throw new IllegalArgumentException("no inverse");
    }

    // Quick demo
    public static void main(String[] args) {
        int[][] key = {{3, 3}, {2, 5}};
        String plain = "meet";
        String cipher = encrypt(plain, key);
        String back = decrypt(cipher, key);
        System.out.println("Plain:  " + plain);
        System.out.println("Cipher: " + cipher);
        System.out.println("Back:   " + back);
    }
}

