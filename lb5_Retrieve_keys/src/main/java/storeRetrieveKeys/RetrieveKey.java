package storeRetrieveKeys;

import java.io.FileInputStream;
import java.security.KeyStore;
import java.security.KeyStore.ProtectionParameter;
import java.security.KeyStore.SecretKeyEntry;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class RetrieveKey {

    public static void main(String[] args) throws Exception {

        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        char[] password = "changeit".toCharArray();
        java.io.FileInputStream fis = new FileInputStream("C:\\Program Files\\Java\\jdk-13.0.2\\lib\\security\\cacerts");
        keyStore.load(fis, password);

        ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);

        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");

        SecretKeyEntry secretKeyEntry = new SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("newKeyStoreName");
        keyStore.store(fos, password);

        SecretKeyEntry secretKeyEnt = (SecretKeyEntry)keyStore.getEntry("secretKeyAlias", protectionParam);
        SecretKey mysecretKey = secretKeyEnt.getSecretKey();

        System.out.println("Algorithm used to generate key : "+mysecretKey.getAlgorithm());
        System.out.println("Format used for the key: "+mysecretKey.getFormat());
        System.out.println(mysecretKey);
    }
}