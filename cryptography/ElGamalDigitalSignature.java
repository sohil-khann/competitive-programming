package cryptography;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.SecureRandom;

public class ElGamalDigitalSignature {
    public static class Keys { public final BigInteger p,g,x,y; public Keys(BigInteger p, BigInteger g, BigInteger x, BigInteger y){ this.p=p; this.g=g; this.x=x; this.y=y; } }
    public static Keys generateKeys(int bits) {
        SecureRandom rnd = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bits, rnd);
        BigInteger g = BigInteger.valueOf(2);
        BigInteger x = new BigInteger(bits-2, rnd).mod(p.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        BigInteger y = g.modPow(x, p);
        return new Keys(p,g,x,y);
    }
    private static BigInteger hash(String m) {
        try {
            MessageDigest md = MessageDigest.getInstance("SHA-256");
            byte[] h = md.digest(m.getBytes());
            return new BigInteger(1, h);
        } catch (Exception ex) { throw new RuntimeException(ex); }
    }
    public static BigInteger[] sign(String message, Keys k) {
        SecureRandom rnd = new SecureRandom();
        BigInteger p = k.p, g = k.g, x = k.x;
        BigInteger h = hash(message).mod(p);
        BigInteger kEp;
        do {
            kEp = new BigInteger(p.bitLength()-2, rnd).mod(p.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        } while (!kEp.gcd(p.subtract(BigInteger.ONE)).equals(BigInteger.ONE));
        BigInteger r = g.modPow(kEp, p);
        BigInteger s = kEp.modInverse(p.subtract(BigInteger.ONE)).multiply(h.subtract(x.multiply(r))).mod(p.subtract(BigInteger.ONE));
        return new BigInteger[]{r,s};
    }
    public static boolean verify(String message, BigInteger[] sig, Keys k) {
        BigInteger p = k.p, g = k.g, y = k.y;
        BigInteger r = sig[0], s = sig[1];
        if (r.compareTo(BigInteger.ZERO) <= 0 || r.compareTo(p) >= 0) return false;
        BigInteger h = hash(message).mod(p);
        BigInteger left = y.modPow(r, p).multiply(r.modPow(s, p)).mod(p);
        BigInteger right = g.modPow(h, p);
        return left.equals(right);
    }
    public static void main(String[] args) {
        Keys keys = generateKeys(256);
        String m = "Hello how are you";
        BigInteger[] sig = sign(m, keys);
        boolean ok = verify(m, sig, keys);
        System.out.println(sig[0].toString().length());
        System.out.println(ok);
    }
}

