package ie.gmit.ds;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

public class Passwords {

	  private static final Random RANDOM = new SecureRandom(); 
	  private static final int ITERATIONS = 10000;
	  private static final int KEY_LENGTH = 256;
	
	private Passwords() {
    }
	
	public static byte[] getNextSalt() {
        byte[] salt = new byte[32];
        RANDOM.nextBytes(salt);
        return salt;
    }
	
	public static byte[] hash(char[] password, byte[] salt) {
		PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS, KEY_LENGTH);
		try {
			SecretKeyFactory skf = SecretKeyFactory.getInstance("PJKDF2WithHmacSHA1");
			return skf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error while hashing a password: "+e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}
	
	public static boolean isExpectedPassword(char[] password, byte[] salt, byte[] expectedHash) {
		byte[] pwdHash = hash(password, salt);
		return Arrays.equals(pwdHash, expectedHash);
	}
	
	public static String generateRandomPassword(int length) {
		StringBuilder sb  = new StringBuilder(length);
		for (int i =0; i < length; i++) {
			int c = RANDOM.nextInt(62);
			if(c <= 9) {
				sb.append(String.valueOf(c));
			} else if (c < 36) {
				sb.append((char) ('a' + c - 10));
			} else {
				sb.append((char) ('A' + c -36));
			}
		}
		return sb.toString();
	}
	
}
