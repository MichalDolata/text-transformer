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
import javax.xml.bind.DatatypeConverter;
import java.nio.charset.StandardCharsets;

public class CipherTransformer {
    private Key key;
    private Cipher cipher;
    private static final String algorithm = "Blowfish";
    private int mode;

    public CipherTransformer(int mode){
        generateKey();
        generateCipherInstance();
        initCipherMode(mode);
        this.mode = mode;
    }

    public String transform(String text){
        byte[] plainText;
        byte[] cipherText;

        if(mode == Cipher.ENCRYPT_MODE) {
            plainText = text.getBytes(StandardCharsets.UTF_8);
        } else {
            plainText = DatatypeConverter.parseBase64Binary(text);
        }

        try {
            cipherText = this.cipher.doFinal(plainText);
        } catch (IllegalBlockSizeException e) {
            System.out.println("Illegal block size exception");
            return("error");
        } catch (BadPaddingException e) {
            System.out.println("Bad padding");
            return("error");
        }

        String result;

        if(mode == Cipher.ENCRYPT_MODE) {
            result = DatatypeConverter.printBase64Binary(cipherText);
        } else {
            result = new String(cipherText, StandardCharsets.UTF_8);
        }

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
        byte[] key_byte = DatatypeConverter.parseBase64Binary(str_key);
        SecretKey key = new SecretKeySpec(key_byte, this.algorithm);
        this.key = key;
    }
}
