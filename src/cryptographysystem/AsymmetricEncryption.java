/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptographysystem;

import java.security.*;
import java.security.spec.KeySpec;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.Base64;
import javax.crypto.Cipher;
import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
/**
 *
 * @author Administrator
 */
public class AsymmetricEncryption {
    // Method to generate key pair
    public static KeyPair generateKeyPair() throws Exception {
        KeyPairGenerator keyPairGenerator = KeyPairGenerator.getInstance("RSA");
        keyPairGenerator.initialize(2048); // You can choose a different key size
        return keyPairGenerator.generateKeyPair();
    }

    // Method to encrypt a message
    public static byte[] encrypt(String message, PublicKey publicKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);
        return cipher.doFinal(message.getBytes());
    }

    // Method to decrypt a message
    public static String decrypt(byte[] encryptedMessage, PrivateKey privateKey) throws Exception {
        Cipher cipher = Cipher.getInstance("RSA");
        cipher.init(Cipher.DECRYPT_MODE, privateKey);
        byte[] decryptedBytes = cipher.doFinal(encryptedMessage);
        return new String(decryptedBytes);
    }
    
    // Method to get X.509 formatted key (either public or private)
    public static String getX509FormattedKey(Key key, String keyType) throws Exception {
        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
        KeySpec keySpec;
        byte[] encoded;

        if (keyType.equals("PUBLIC")) {
            keySpec = keyFactory.getKeySpec(key, X509EncodedKeySpec.class);
            encoded = ((X509EncodedKeySpec) keySpec).getEncoded();
        } else if (keyType.equals("PRIVATE")) {
            keySpec = keyFactory.getKeySpec(key, PKCS8EncodedKeySpec.class);
            encoded = ((PKCS8EncodedKeySpec) keySpec).getEncoded();
        } else {
            throw new IllegalArgumentException("Invalid key type");
        }

        return "-----BEGIN " + keyType + " KEY-----\n" + Base64.getEncoder().encodeToString(encoded) + "\n-----END " + keyType + " KEY-----";
    }
    
    // Method to convert an X.509 formatted public key string to RSAPublicKey object
    public static PublicKey getPublicKeyFromX509String(String keyString) throws Exception {
        // Check for headers and footers
        if (!keyString.startsWith("-----BEGIN PUBLIC KEY-----") || !keyString.endsWith("-----END PUBLIC KEY-----")) {
            throw new IllegalArgumentException("Invalid X.509 public key format");
        }

        // Extract base64-encoded key without headers and footers, trim whitespace
        String base64EncodedKey = keyString
                .replace("-----BEGIN PUBLIC KEY-----", "")
                .replace("-----END PUBLIC KEY-----", "")
                .replaceAll("\\s", "");

        try {
            byte[] keyBytes = Base64.getDecoder().decode(base64EncodedKey);
            X509EncodedKeySpec spec = new X509EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePublic(spec);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting public key string to RSAPublicKey", e);
        }
    }

    // Method to convert an X.509 formatted private key string to RSAPrivateKey object
    public static PrivateKey getPrivateKeyFromPKCS8String(String keyString) throws Exception {
        // Check for headers and footers
        if (!keyString.startsWith("-----BEGIN PRIVATE KEY-----") || !keyString.endsWith("-----END PRIVATE KEY-----")) {
            throw new IllegalArgumentException("Invalid PKCS#8 private key format");
        }

        // Extract base64-encoded key without headers and footers, trim whitespace
        String base64EncodedKey = keyString
                .replace("-----BEGIN PRIVATE KEY-----", "")
                .replace("-----END PRIVATE KEY-----", "")
                .replaceAll("\\s", "");

        try {
            byte[] keyBytes = Base64.getDecoder().decode(base64EncodedKey);
            PKCS8EncodedKeySpec spec = new PKCS8EncodedKeySpec(keyBytes);
            KeyFactory keyFactory = KeyFactory.getInstance("RSA");
            return keyFactory.generatePrivate(spec);
        } catch (Exception e) {
            throw new IllegalArgumentException("Error converting private key string to RSAPrivateKey", e);
        }
    }
    
    public static void encryptAndSaveToFile(String message, String filePath, PublicKey publicKey) throws Exception {

        // Encrypt the data with RSA
        byte[] encryptedData = encrypt(message, publicKey);

        // Save the encrypted data to a file
        try (OutputStream outputStream = new FileOutputStream(filePath)) {
            outputStream.write(encryptedData);
        }
    }
    
    public static byte[] readEncryptedFile(String filePath) throws IOException {
        Path path = Path.of(filePath);
        return Files.readAllBytes(path);
    }
    
}
