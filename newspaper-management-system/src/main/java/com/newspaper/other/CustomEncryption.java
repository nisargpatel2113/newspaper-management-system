/**
 * 
 */
package com.newspaper.other;

import java.math.BigInteger;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * @author tarkhand
 *
 */
public class CustomEncryption {
	public static String encrypt(String str) {
		MessageDigest messageDigest = null;
		String salt = "encrypt";
		String hashText = "";
		String saltedPassword = salt + str;
		System.out.println(saltedPassword);
		try {
			messageDigest = MessageDigest.getInstance("SHA-512");
			byte[] bytes = messageDigest.digest(saltedPassword.getBytes());
			BigInteger bigInteger = new BigInteger(1, bytes);
			hashText = bigInteger.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}

		return hashText;
	}
}
