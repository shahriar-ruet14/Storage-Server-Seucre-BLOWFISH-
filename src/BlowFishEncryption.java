import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;

public class BlowFishEncryption {
	
	
	public static String blowFishEncryption(String plainText) throws Exception {
		print("Client1>Message>BlowFishEncryption> : BlowFish Initializing....\n");
		
		SecretKey secretKey = KeyStatic.key(); //Generate key for the very first time of a communication 
		
		
		
		long tic = System.nanoTime(); //Time Stamp
		// create a cipher based upon Blowfish
	    Cipher cipher = Cipher.getInstance("Blowfish");

	    // initialise cipher to with secret key
	    cipher.init(Cipher.ENCRYPT_MODE, secretKey);

	    

	    // encrypt message
	    byte[] encrypted = cipher.doFinal(plainText.getBytes());
	    Base64.Encoder encoder = Base64.getEncoder();
		String encryptedText = encoder.encodeToString(encrypted);
		
		
		 long toc = System.nanoTime(); //final time
		 long elapsedTime = toc - tic;
		 System.out.println("\nBlowFishEncryption: Elapsed Time : "+ elapsedTime+" ns \n \t  \t OR " 
			+ elapsedTime/1000000000+" Seconds");
			
		return encryptedText;

		
	}
	
	
	public static void print(Object e)
	{
		System.out.println(e);
	}

}
