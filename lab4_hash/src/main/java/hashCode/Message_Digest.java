package hashCode;

import java.security.MessageDigest;
import java.util.Scanner;

public class Message_Digest {

    public static void main(String[] args) throws Exception{

        Scanner scan = new Scanner(System.in);
        System.out.println("Enter the message: ");
        
        String message = scan.nextLine();
        MessageDigest md = MessageDigest.getInstance("SHA-256");
        
        md.update(message.getBytes());

        byte[] digest = md.digest();

        System.out.println(digest);

        StringBuffer hexString = new StringBuffer();

        for (int i=0; i<digest.length; i++) {

            hexString.append(Integer.toHexString(digest[i] & 0xFF));
        }

        System.out.println("Hexadecimal format: "+ hexString.toString());
    }
}