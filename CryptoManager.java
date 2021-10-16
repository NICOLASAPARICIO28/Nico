/*
 * Class: CMSC203 
 * Instructor: Prof. Alexander
 * Description: This program creats a GUI that allows users to input a string that can encrypted
 * and decrypted using two different algorithms
 * Due: 10/15/2021
 * Platform/compiler:
 * I pledge that I have completed the programming assignment independently.
   I have not copied the code from a student or any source.
   I have not given my code to any student.
   Print your Name here: Nicolas Aparicio-Felix
*/

public class CryptoManager {
	
	private static final char LOWER_BOUND = 32;
	private static final char UPPER_BOUND = 95;
	private static final int RANGE = UPPER_BOUND - LOWER_BOUND + 1;

	/**
	 * This method determines if a string is within the allowable bounds of ASCII codes 
	 * according to the LOWER_BOUND and UPPER_BOUND characters
	 * @param plainText a string to be encrypted, if it is within the allowable bounds
	 * @return true if all characters are within the allowable bounds, false if any character is outside
	 */
	public static boolean stringInBounds (String plainText) {
		boolean flag = true;
		
		for (int i = 0; i < plainText.length(); i++) {
		
			if (((int)plainText.charAt(i) <= UPPER_BOUND) && !((int)plainText.charAt(i) >= LOWER_BOUND)) {
			flag = false;
			}
			
		}
		return flag;
		//throw new RuntimeException("method not implemented");
		
	}

	/**
	 * Encrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in plainText is replaced by the character \"offset\" away from it 
	 * @param plainText an uppercase string to be encrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the encrypted string
	 */
	public static String encryptCaesar(String plainText, int key) {
		String encryptedText = "";
		
		if (stringInBounds(plainText)) {
			for (int i = 0; i < plainText.length(); i++) {
				char textChar = plainText.charAt(i);
				
				int encryptedCharText = ((int)textChar + key);
				
				while (encryptedCharText > UPPER_BOUND) {
					encryptedCharText -= RANGE;
				}
				encryptedText += (char)encryptedCharText;
			}
			
		}
		return encryptedText;
		//throw new RuntimeException("method not implemented");
		
	}
	
	/**
	 * Encrypts a string according the Bellaso Cipher.  Each character in plainText is offset 
	 * according to the ASCII value of the corresponding character in bellasoStr, which is repeated
	 * to correspond to the length of plainText
	 * @param plainText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the encrypted string
	 */
	public static String encryptBellaso(String plainText, String bellasoStr) {
		String encryptedText = "";
		
		int bellasoLength = bellasoStr.length();
		
		for (int i = 0; i < plainText.length(); i++) {
			char textChar = plainText.charAt(i);
			
			int encryptedCharText = ((int)textChar + (int)bellasoStr.charAt(i%bellasoLength));
			
			while (encryptedCharText > (int)UPPER_BOUND) {
				
				encryptedCharText -= RANGE;
				
			}
			encryptedText += (char)encryptedCharText;
			
		}
		
		return encryptedText;
		
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according to the Caesar Cipher.  The integer key specifies an offset
	 * and each character in encryptedText is replaced by the character \"offset\" characters before it.
	 * This is the inverse of the encryptCaesar method.
	 * @param encryptedText an encrypted string to be decrypted.
	 * @param key an integer that specifies the offset of each character
	 * @return the plain text string
	 */
	public static String decryptCaesar(String encryptedText, int key) {
		String decryptedText = "";
		
		for (int i = 0; i < encryptedText.length(); i++) {
			char textChar = encryptedText.charAt(i);
			
			int decryptedCharText = ((int)textChar - key);
			
			while (decryptedCharText < LOWER_BOUND) {
				decryptedCharText += RANGE;
			}
			decryptedText += (char)decryptedCharText;
			
		}
		return decryptedText;
		//throw new RuntimeException("method not implemented");
	}
	
	/**
	 * Decrypts a string according the Bellaso Cipher.  Each character in encryptedText is replaced by
	 * the character corresponding to the character in bellasoStr, which is repeated
	 * to correspond to the length of plainText.  This is the inverse of the encryptBellaso method.
	 * @param encryptedText an uppercase string to be encrypted.
	 * @param bellasoStr an uppercase string that specifies the offsets, character by character.
	 * @return the decrypted string
	 */
	public static String decryptBellaso(String encryptedText, String bellasoStr) {
		String decryptedText = "";
		
		int bellasoLength = bellasoStr.length();
		
		for (int i = 0; i < encryptedText.length(); i++) {
			char textChar = encryptedText.charAt(i);
			
			int decryptedCharText = ((int)textChar - (int)bellasoStr.charAt(i % bellasoLength));
			
			while (decryptedCharText < ((int)LOWER_BOUND)) {
				decryptedCharText += RANGE;
			}
			decryptedText += (char)decryptedCharText;
			
		}
		return decryptedText;
		//throw new RuntimeException("method not implemented");
	}
}    