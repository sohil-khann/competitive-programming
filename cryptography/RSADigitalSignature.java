package cryptography;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class RSADigitalSignature {
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
    private static BigInteger hash(String m) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] h = md.digest(m.getBytes());
            return new BigInteger(1, h);
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }
    public static BigInteger sign(String message, KeyPair kp) {
        BigInteger h = hash(message);
        return h.modPow(kp.d, kp.n);
    }
    public static boolean verify(String message, BigInteger signature, KeyPair kp) {
        BigInteger h = hash(message);
        BigInteger v = signature.modPow(kp.e, kp.n);
        return v.equals(h.mod(kp.n));
    }
    public static void main(String[] args) {
        KeyPair kp = generateKeys(512);
        String m = "This is an example";
        BigInteger s = sign(m, kp);
        boolean ok = verify(m, s, kp);
        System.out.println(s.toString().length());
        System.out.println(ok);
    }
}

