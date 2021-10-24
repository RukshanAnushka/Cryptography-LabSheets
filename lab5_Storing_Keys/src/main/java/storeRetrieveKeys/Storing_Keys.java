package storeRetrieveKeys;

import java.io.FileInputStream;
import java.security.KeyStore;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

public class Storing_Keys {

    public static void main(String[] args) throws Exception {

        KeyStore keyStore = KeyStore.getInstance("JCEKS");

        char[] password = "changeit".toCharArray();
        String path = "C:\\Program Files\\Java\\jdk-13.0.2\\lib\\security\\cacerts";
        java.io.FileInputStream fis = new FileInputStream(path);
        keyStore.load(fis, password);

        KeyStore.ProtectionParameter protectionParam = new KeyStore.PasswordProtection(password);
        SecretKey mySecretKey = new SecretKeySpec("myPassword".getBytes(), "DSA");

        KeyStore.SecretKeyEntry secretKeyEntry = new KeyStore.SecretKeyEntry(mySecretKey);
        keyStore.setEntry("secretKeyAlias", secretKeyEntry, protectionParam);

        java.io.FileOutputStream fos = null;
        fos = new java.io.FileOutputStream("newKeyStoreName");
        keyStore.store(fos, password);
        System.out.println("data stored");
        }
    } 
