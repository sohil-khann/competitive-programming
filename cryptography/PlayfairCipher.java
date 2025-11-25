package cryptography;
public class PlayfairCipher {
    // Encrypt: lowercase -> uppercase digraphs
    public static String encrypt(String plain, String key) {
        char[][] m = buildMatrix(key);
        String p = prepare(plain);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < p.length(); i += 2) {
            char a = p.charAt(i), b = p.charAt(i + 1);
            int[] pa = locate(m, a), pb = locate(m, b);
            if (pa[0] == pb[0]) {
                out.append(m[pa[0]][(pa[1] + 1) % 5]).append(m[pb[0]][(pb[1] + 1) % 5]);
            } else if (pa[1] == pb[1]) {
                out.append(m[(pa[0] + 1) % 5][pa[1]]).append(m[(pb[0] + 1) % 5][pb[1]]);
            } else {
                out.append(m[pa[0]][pb[1]]).append(m[pb[0]][pa[1]]);
            }
        }
        return out.toString();
    }

    // Decrypt: uppercase -> lowercase
    public static String decrypt(String cipher, String key) {
        char[][] m = buildMatrix(key);
        StringBuilder out = new StringBuilder();
        for (int i = 0; i < cipher.length(); i += 2) {
            char a = cipher.charAt(i), b = cipher.charAt(i + 1);
            int[] pa = locate(m, a), pb = locate(m, b);
            if (pa[0] == pb[0]) {
                out.append(Character.toLowerCase(m[pa[0]][(pa[1] + 4) % 5]))
                   .append(Character.toLowerCase(m[pb[0]][(pb[1] + 4) % 5]));
            } else if (pa[1] == pb[1]) {
                out.append(Character.toLowerCase(m[(pa[0] + 4) % 5][pa[1]]))
                   .append(Character.toLowerCase(m[(pb[0] + 4) % 5][pb[1]]));
            } else {
                out.append(Character.toLowerCase(m[pa[0]][pb[1]]))
                   .append(Character.toLowerCase(m[pb[0]][pa[1]]));
            }
        }
        return out.toString();
    }

    // Helpers
    private static char[][] buildMatrix(String key) {
        key = key.toUpperCase().replace('J', 'I');
        boolean[] used = new boolean[26];
        char[][] m = new char[5][5];
        int idx = 0;
        for (char c : key.toCharArray()) if (!used[c - 'A'] && c != 'J') { used[c - 'A'] = true; m[idx / 5][idx % 5] = c; idx++; }
        for (char c = 'A'; c <= 'Z'; c++) if (!used[c - 'A'] && c != 'J') { m[idx / 5][idx % 5] = c; idx++; }
        return m;
    }

    private static int[] locate(char[][] m, char ch) {
        ch = Character.toUpperCase(ch);
        if (ch == 'J') ch = 'I';
        for (int r = 0; r < 5; r++) for (int c = 0; c < 5; c++) if (m[r][c] == ch) return new int[]{r, c};
        return null;
    }

    private static String prepare(String plain) {
        plain = plain.replace('j', 'i');
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < plain.length(); i++) {
            char a = plain.charAt(i);
            char b = (i + 1 < plain.length()) ? plain.charAt(i + 1) : 'x';
            if (a == b) { sb.append(a).append('x'); }
            else { sb.append(a).append(b); i++; }
        }
        if (sb.length() % 2 != 0) sb.append('x');
        return sb.toString();
    }

    // Quick demo
    public static void main(String[] args) {
        String plain = "hidethegold";
        String key = "keyword";
        String cipher = encrypt(plain, key);
        String back = decrypt(cipher, key);
        System.out.println("Plain:  " + plain);
        System.out.println("Cipher: " + cipher);
        System.out.println("Back:   " + back);
    }
}

