package key_Keypair;

import javax.crypto.Cipher;
import javax.crypto.KeyGenerator;
import java.security.Key;
import java.security.SecureRandom;

public class Key_Gen {

    public static void main(String args[]) throws Exception{

        KeyGenerator keyGen = KeyGenerator.getInstance("AES");
        
        SecureRandom secRandom = new SecureRandom();
        
        keyGen.init(128, secRandom);

        Key key = keyGen.generateKey();
        System.out.println(key);
        Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
        cipher.init(Cipher.ENCRYPT_MODE, key);
        String msg = new String("Hi how are you");
        byte[] bytes = cipher.doFinal(msg.getBytes());
        System.out.println(bytes);

    }
}