/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cryptographysystem;
import javax.swing.*;

/**
 *
 * @author Administrator
 */
public class CaesarCipher {
    private static final String ALPHABET = "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789.,?!@#$%^&*()-_+=<>;:[]{}|";
    
    public static String encrypt(String message, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : message.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';
                encryptedText.append((char) ((character - base + shift) % 26 + base));
            } else {
                encryptedText.append(character);
            }
        }

        return encryptedText.toString();
    }

    public static String decrypt(String encryptedMessage, int shift) {
        StringBuilder decryptedText = new StringBuilder();

        for (char character : encryptedMessage.toCharArray()) {
            if (Character.isLetter(character)) {
                char base = Character.isLowerCase(character) ? 'a' : 'A';

                // Adjust the shift to handle shifts larger than 26
                int adjustedShift = shift % 26;

                // Handle negative shifts
                if (character - base - adjustedShift < 0) {
                    decryptedText.append((char) ((character - base - adjustedShift + 26) % 26 + base));
                } else {
                    decryptedText.append((char) ((character - base - adjustedShift) % 26 + base));
                }
            } else {
                decryptedText.append(character);
            }
        }

        return decryptedText.toString();
    }

    public static String encryptAdvance(String message, int shift) {
        StringBuilder encryptedText = new StringBuilder();

        for (char character : message.toCharArray()) {
            int index = ALPHABET.indexOf(character);
            if (index != -1) {
                int shiftedIndex = (index + shift) % ALPHABET.length();
                encryptedText.append(ALPHABET.charAt(shiftedIndex));
            } else {
                encryptedText.append(character);  // Non-alphabetic characters remain unchanged
            }
        }

        return encryptedText.toString();
    }
}
