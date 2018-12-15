package pl.put.poznan.transformer.logic;

import javax.crypto.Cipher;
import java.security.Key;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import java.security.NoSuchAlgorithmException;
import java.security.InvalidKeyException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.BadPaddingException;


public class CipherTransformer {
    private Key key;
    private Cipher cipher;
    private static final String algorithm = "Blowfish";

    public CipherTransformer(int mode){
        generateKey();
        generateCipherInstance();
        initCipherMode(mode);
    }

    public String transform(String text){
        byte[] plainText = text.getBytes();
        byte[] cipherText;

        try {
            cipherText = this.cipher.doFinal(plainText);
        } catch (IllegalBlockSizeException e) {
            System.out.println("Illegal block size exception");
            return("error");
        } catch (BadPaddingException e) {
            System.out.println("Bad padding");
            return("error");
        }

        String result = new String(cipherText);
        return(result);
    }

    private void initCipherMode(int mode){
        try {
            this.cipher.init(mode, this.key);
        } catch (InvalidKeyException e) {
            System.out.println("Invalid key");
        }
    }

    private void generateCipherInstance(){
        try {
            this.cipher = Cipher.getInstance(this.algorithm);
        } catch ( NoSuchAlgorithmException e) {
            System.out.println("No such algorithm");
        } catch (NoSuchPaddingException e) {
            System.out.println("No such padding");
        }
    }

    private void generateKey(){
        String str_key = "java is the best";
        byte[] key_byte = str_key.getBytes();
        SecretKey key = new SecretKeySpec(key_byte, this.algorithm);
        this.key = key;
    }
}
