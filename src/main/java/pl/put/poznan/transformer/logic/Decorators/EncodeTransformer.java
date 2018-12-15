package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.CipherTransformer;

import javax.crypto.Cipher;

/**
 * Created by Michal on 15.12.2018.
 */
public class EncodeTransformer extends Decorator  {

    public EncodeTransformer(TextTransformer decorator) {
        super(decorator);
    }

    /**
     * This function is used for encrypt string.
     * @param text - Input string that will be changed
     * @return string where encrypted
     */
    @Override
    public String transform(String text){
        logger.debug("UpperTransformer input: "+text);
        text = super.transform(text);
        CipherTransformer dt = new CipherTransformer(Cipher.ENCRYPT_MODE);
        text = dt.transform(text);
        logger.debug("UpperTransformer output: "+text);
        return text;
    }
}
