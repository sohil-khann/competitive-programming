package cryptography;
import java.math.BigInteger;
import java.security.SecureRandom;

public class MillerRabinPrimalityTest {
    public static boolean isPrime(BigInteger n, int k) {
        if (n.compareTo(BigInteger.TWO) < 0) return false;
        if (n.mod(BigInteger.TWO).equals(BigInteger.ZERO)) return n.equals(BigInteger.TWO);
        BigInteger d = n.subtract(BigInteger.ONE);
        int r = 0;
        while (d.mod(BigInteger.TWO).equals(BigInteger.ZERO)) { d = d.divide(BigInteger.TWO); r++; }
        SecureRandom rnd = new SecureRandom();
        for (int i = 0; i < k; i++) {
            BigInteger a = uniform(BigInteger.TWO, n.subtract(BigInteger.TWO), rnd);
            BigInteger x = a.modPow(d, n);
            if (x.equals(BigInteger.ONE) || x.equals(n.subtract(BigInteger.ONE))) continue;
            boolean continueWitness = false;
            for (int j = 0; j < r - 1; j++) {
                x = x.modPow(BigInteger.TWO, n);
                if (x.equals(n.subtract(BigInteger.ONE))) { continueWitness = true; break; }
            }
            if (!continueWitness) return false;
        }
        return true;
    }
    private static BigInteger uniform(BigInteger min, BigInteger max, SecureRandom rnd) {
        BigInteger range = max.subtract(min).add(BigInteger.ONE);
        int bits = range.bitLength();
        BigInteger x;
        do { x = new BigInteger(bits, rnd); } while (x.compareTo(range) >= 0);
        return x.add(min);
    }
    public static void main(String[] args) {
        System.out.println(isPrime(new BigInteger("97"), 8));
        System.out.println(isPrime(new BigInteger("221"), 8));
    }
}

