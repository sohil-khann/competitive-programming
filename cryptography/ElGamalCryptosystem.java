package cryptography;
import java.math.BigInteger;
import java.security.SecureRandom;

public class ElGamalCryptosystem {
    public static class Keys { public final BigInteger p,g,x,y; public Keys(BigInteger p, BigInteger g, BigInteger x, BigInteger y){ this.p=p; this.g=g; this.x=x; this.y=y; } }
    public static Keys generateKeys(int bits) {
        SecureRandom rnd = new SecureRandom();
        BigInteger p = BigInteger.probablePrime(bits, rnd);
        BigInteger g = BigInteger.valueOf(2);
        BigInteger x = new BigInteger(bits-2, rnd).mod(p.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        BigInteger y = g.modPow(x, p);
        return new Keys(p,g,x,y);
    }
    public static BigInteger[] encrypt(BigInteger m, Keys k) {
        SecureRandom rnd = new SecureRandom();
        BigInteger p = k.p, g = k.g, y = k.y;
        BigInteger kEp = new BigInteger(p.bitLength()-2, rnd).mod(p.subtract(BigInteger.ONE)).add(BigInteger.ONE);
        BigInteger c1 = g.modPow(kEp, p);
        BigInteger s = y.modPow(kEp, p);
        BigInteger c2 = m.multiply(s).mod(p);
        return new BigInteger[]{c1,c2};
    }
    public static BigInteger decrypt(BigInteger[] c, Keys k) {
        BigInteger p = k.p, x = k.x;
        BigInteger c1 = c[0], c2 = c[1];
        BigInteger s = c1.modPow(x, p);
        BigInteger inv = s.modInverse(p);
        return c2.multiply(inv).mod(p);
    }
    public static void main(String[] args) {
        Keys keys = generateKeys(256);
        BigInteger m = BigInteger.valueOf(12345);
        BigInteger[] c = encrypt(m, keys);
        BigInteger d = decrypt(c, keys);
        System.out.println(keys.p.toString().length());
        System.out.println(d);
    }
}

