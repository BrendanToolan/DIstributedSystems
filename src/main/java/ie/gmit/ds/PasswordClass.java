package ie.gmit.ds;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Random;

public class PasswordClass {

	private static final Random RANDOM = new SecureRandom();
	private static final int iter = 10000;
	public static final int lenght = 256;
	
	private PasswordClass() {
    }
	
	public static byte[] getSalt() {
		byte[] salt = new byte[32];
		RANDOM.nextBytes(salt);
		return salt;
	}
	
	public static byte[] hash(char[] password, byte[] salt) {
		PBEKeySpec spec = new PBEKeySpec(password, salt, iter, lenght);
		try {
			SecretKeyFactory sf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
			return sf.generateSecret(spec).getEncoded();
		} catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
			throw new AssertionError("Error hashing password: "+e.getMessage(), e);
		} finally {
			spec.clearPassword();
		}
	}
	
	public static boolean isExpected(char[] password, byte[] salt, byte[] hashExpect)
	{
		byte[] passwordHash = hash(password, salt);
		return Arrays.equals(passwordHash, hashExpect);
	}
	
	public static String generateRandomPassword(int length) {
        StringBuilder sb = new StringBuilder(length);
        for (int i = 0; i < length; i++) {
            int c = RANDOM.nextInt(62);
            if (c <= 9) {
                sb.append(String.valueOf(c));
            } else if (c < 36) {
                sb.append((char) ('a' + c - 10));
            } else {
                sb.append((char) ('A' + c - 36));
            }
        }
        return sb.toString();
    }
	
}
