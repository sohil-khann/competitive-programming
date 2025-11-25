package cryptography;
import java.math.BigInteger;
import java.security.SecureRandom;

public class DiffieHellmanKeyExchange {
    public static class Pair { public final BigInteger p,g,A,B,sA,sB; public Pair(BigInteger p, BigInteger g, BigInteger A, BigInteger B, BigInteger sA, BigInteger sB){ this.p=p; this.g=g; this.A=A; this.B=B; this.sA=sA; this.sB=sB; } }
    public static Pair exchange(int bits) {
        SecureRandom rnd = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bits, rnd);
        BigInteger g = BigInteger.valueOf(2);
        BigInteger a = new BigInteger(bits-2, rnd).mod(p.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        BigInteger b = new BigInteger(bits-2, rnd).mod(p.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        BigInteger A = g.modPow(a, p);
        BigInteger B = g.modPow(b, p);
        BigInteger sA = B.modPow(a, p);
        BigInteger sB = A.modPow(b, p);
        return new Pair(p,g,A,B,sA,sB);
    }
    public static String encryptWithSharedShift(String plaintext, BigInteger shared) {
        if (!plaintext.matches("[a-z]+")) throw new IllegalArgumentException("invalid plaintext");
        int key = shared.mod(BigInteger.valueOf(26)).intValue();
        StringBuilder sb = new StringBuilder();
        for (char ch : plaintext.toCharArray()) {
            int p = ch - 'a';
            int c = (p + key) % 26;
            sb.append((char)('A' + c));
        }
        return sb.toString();
    }
    public static String decryptWithSharedShift(String ciphertext, BigInteger shared) {
        if (!ciphertext.matches("[A-Z]+")) throw new IllegalArgumentException("invalid ciphertext");
        int key = shared.mod(BigInteger.valueOf(26)).intValue();
        StringBuilder sb = new StringBuilder();
        for (char ch : ciphertext.toCharArray()) {
            int c = ch - 'A';
            int p = (c - key + 26) % 26;
            sb.append((char)('a' + p));
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        Pair p = exchange(192);
        String m = "sharedkeymessage";
        String c = encryptWithSharedShift(m, p.sA);
        String d = decryptWithSharedShift(c, p.sB);
        System.out.println(c);
        System.out.println(d);
    }
}

