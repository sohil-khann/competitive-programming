package cryptography;
import java.math.BigInteger;
import java.security.SecureRandom;

public class RSAEncryption {
    public static class KeyPair { public final BigInteger n,e,d; public KeyPair(BigInteger n, BigInteger e, BigInteger d){ this.n=n; this.e=e; this.d=d; } }
    public static KeyPair generateKeys(int bits) {
        SecureRandom rnd = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bits/2, rnd);
        BigInteger q = BigInteger.probablePrime(bits/2, rnd);
        BigInteger n = p.multiply(q);
        BigInteger phi = p.subtract(BigInteger.ONE).multiply(q.subtract(BigInteger.ONE));
        BigInteger e = BigInteger.valueOf(65537);
        if (!phi.gcd(e).equals(BigInteger.ONE)) e = BigInteger.valueOf(3);
        BigInteger d = e.modInverse(phi);
        return new KeyPair(n,e,d);
    }
    public static BigInteger[] encrypt(String message, KeyPair kp) {
        BigInteger[] out = new BigInteger[message.length()];
        for (int i = 0; i < message.length(); i++) {
            BigInteger m = BigInteger.valueOf(message.charAt(i));
            out[i] = m.modPow(kp.e, kp.n);
        }
        return out;
    }
    public static String decrypt(BigInteger[] ciphertext, KeyPair kp) {
        StringBuilder sb = new StringBuilder();
        for (BigInteger c : ciphertext) {
            BigInteger m = c.modPow(kp.d, kp.n);
            sb.append((char)m.intValue());
        }
        return sb.toString();
    }
    public static void main(String[] args) {
        KeyPair kp = generateKeys(512);
        String m = "Hello RSA";
        BigInteger[] c = encrypt(m, kp);
        String d = decrypt(c, kp);
        System.out.println(c.length);
        System.out.println(d);
    }
}

