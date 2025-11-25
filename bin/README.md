# competitive-programming

A collection of classic and modern cryptography implementations in Java, designed for competitive programming and educational purposes.

## 📁 Cryptography Folder

Contains 12 cipher implementations split into two categories:

### Classical Ciphers (1–6)
1. **ShiftCipher.java** – Caesar cipher with shift key
2. **MultiplicativeCipher.java** – Multiplicative cipher (key must be coprime with 26)
3. **AffineCipher.java** – Affine cipher combining shift and multiplicative
4. **VigenereCipher.java** – Keyword-based polyalphabetic cipher
5. **PlayfairCipher.java** – Digraph cipher using 5×5 matrix
6. **HillCipher.java** – Matrix-based cipher (2×2 key matrix)

### Modern Cryptography (7–12)
7. **ElGamalCryptosystem.java** – Public-key encryption with key generation
8. **MillerRabinPrimalityTest.java** – Probabilistic primality testing
9. **DiffieHellmanKeyExchange.java** – Secure key exchange protocol
10. **RSAEncryption.java** – RSA public-key encryption/decryption
11. **RSADigitalSignature.java** – RSA digital signatures with SHA-256
12. **ElGamalDigitalSignature.java** – ElGamal signature scheme

## 🎯 Features

- **Beginner-friendly code** – Clear comments, simple structure
- **Input validation** – Enforces lowercase plaintext, uppercase ciphertext
- **Brute-force functions** – For classical ciphers (where applicable)
- **Working demos** – Each file includes a main method with examples
- **No external dependencies** – Pure Java implementations

## 🚀 Quick Start

```bash
# Compile all files
javac cryptography/*.java

# Run any cipher demo
java cryptography.ShiftCipher
```

## 📋 Usage Example

```java
// Shift cipher example
String plain = "hello";
int key = 3;
String cipher = ShiftCipher.encrypt(plain, key);
String back = ShiftCipher.decrypt(cipher, key);
System.out.println(cipher); // KHOOR
```