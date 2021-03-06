package program1;
import java.util.*;

public class CeaserCipher_a 
{
    public static StringBuffer encrypt(String text, int s)
    {
        StringBuffer result= new StringBuffer();
        
        for (int i=0; i<text.length(); i++)
    {
        if (Character.isUpperCase(text.charAt(i)))
        {
            char ch = (char)(((int)text.charAt(i) + s - 65) % 26 + 65);
            result.append(ch);
        }
        else
        {
            char ch = (char)(((int)text.charAt(i) + s - 97) % 26 + 97);
            result.append(ch);
        }
    }
        return result;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Text: ");
        String text = sc.nextLine();
        System.out.println("Enter the shift value: ");
        int s = sc.nextInt();
        System.out.println("Text : " + text);
        System.out.println("Shift : " + s);
        System.out.println("Cipher: " + encrypt(text, s));
    }
}
