package cipherText;

import java.util.*;
import java.security.Key;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import javax.crypto.Cipher;

public class Decryp_tion {

    public static void main(String[] args) throws Exception{

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter some text");
        String msg = sc.nextLine();

        Signature sign = Signature.getInstance("SHA256withRSA");
        KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
        keyPairGen.initialize(2048);
        KeyPair pair = keyPairGen.generateKeyPair();
        PrivateKey privKey = pair.getPrivate();
        Cipher cipher = Cipher.getInstance("RSA/ECB/PKCS1Padding");
        cipher.init(Cipher.ENCRYPT_MODE, privKey);
        byte[] input = msg.getBytes();
        cipher.update(input);

        byte[] cipherText = cipher.doFinal();
        System.out.println( new String(cipherText, "UTF8"));

        cipher.init(Cipher.DECRYPT_MODE, pair.getPublic());

        byte[] decipheredText = cipher.doFinal(cipherText);
        System.out.println(new String(decipheredText));

    }
}