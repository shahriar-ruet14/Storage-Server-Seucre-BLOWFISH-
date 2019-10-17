import java.util.Base64;

import javax.crypto.Cipher;
import javax.crypto.SecretKey;
import javax.swing.JOptionPane;

public class BlowFishDecryption{
	public static void blowfishDecryption(String ciphertext) throws Exception {
		
		System.out.println("\nBlowfish Decryption Initializing");
		
		
		SecretKey secretKey = KeyStatic.key(); // Get existing Key
		long tic = System.nanoTime(); //Time Stamp
		
		
		
		Cipher cipher = Cipher.getInstance("Blowfish");
		Base64.Decoder decoder = Base64.getDecoder();
		byte[] encryptedTextByte = decoder.decode(ciphertext);
		
	    // re-initialise the cipher to be in decrypt mode
	    cipher.init(Cipher.DECRYPT_MODE, secretKey);
	    byte[] decrypted = cipher.doFinal(encryptedTextByte);
	    
	    long toc = System.nanoTime(); //final time
	    long elapsedTime = toc - tic;
		System.out.println("\nBlowFishDecryption: Elapsed Time : "+ elapsedTime+" ns \n \t  \t OR " 
		+ elapsedTime/1000000000+" Seconds");
	    
		
		
		print("\nClient1> message>BlowFishDecryption >> : Decrypted Final Text:\n\n\t\t" +new String(decrypted));
		print("\n\n\n\n");
	    
	    
	    JOptionPane.showMessageDialog(JOptionPane.getRootFrame(),
               "encrypted text: " + new String(ciphertext) + "\n" +
               "decrypted text: " + new String(decrypted));
      



		
		
		
	}
	
	public static void print(Object e)
	{
		System.out.println(e);
	}
	
	
	
}