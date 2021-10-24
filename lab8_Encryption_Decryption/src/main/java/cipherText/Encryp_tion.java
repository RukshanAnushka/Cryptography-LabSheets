package cipherText;

import java.util.*;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.Signature;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;

public class Encryp_tion {
   public static void main(String args[]) throws Exception
   {
       Scanner sc =new Scanner(System.in);
       System.out.println("Enter the text here");
       String msg =sc.nextLine();
       
      Signature sign = Signature.getInstance("SHA256withRSA");
     
      KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
      
      keyPairGen.initialize(2048);
      
      KeyPair pair = keyPairGen.generateKeyPair();    
     
      Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        
      cipher.init(Cipher.ENCRYPT_MODE, pair.getPublic());
	  
      byte[] input = msg.getBytes();	  
      cipher.update(input);
	  
      byte[] cipherText = cipher.doFinal();	
       System.out.println("Encrypted Text");
      System.out.println(new String(cipherText, "UTF8"));
   }
}