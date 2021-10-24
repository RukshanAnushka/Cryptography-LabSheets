package macCode;

import java.util.Scanner;
import java.security.Key;
import java.security.SecureRandom;
import javax.crypto.KeyGenerator;
import javax.crypto.Mac;

public class MACEncryption {

    public static void main(String[] args) throws Exception {

        KeyGenerator KeyGen = KeyGenerator.getInstance("DES");

        SecureRandom secRandom = new SecureRandom();

        KeyGen.init(secRandom);

        Key key = KeyGen.generateKey();

        Mac mac = Mac.getInstance("HmacSHA256");

        mac.init(key);

        Scanner sc = new Scanner(System.in);
        String message = new String();
        System.out.println("Enter the message to encrypt: ");
        message = sc.nextLine();

        byte[] bytes = message.getBytes(); 
        byte[] macResult = mac.doFinal(bytes);

        System.out.println("MAC result is: " + new String(macResult));
    }
}