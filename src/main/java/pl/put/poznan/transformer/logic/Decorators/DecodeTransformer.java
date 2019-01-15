package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.CipherTransformer;

import javax.crypto.Cipher;

/**
 * Created by Michal on 15.12.2018.
 */
public class DecodeTransformer extends Decorator  {
    private CipherTransformer dt;

    public DecodeTransformer(TextTransformer decorator, CipherTransformer dt) {
        super(decorator);
        this.dt = dt;
    }

    /**
     * This function is used for decrypt string.
            * @param text - Input string that will be changed
     * @return string where decrypted
     */
    @Override
    public String transform(String text){
        logger.debug("DecodeTransformer input: "+text);
        text = super.transform(text);
        text = dt.transform(text);
        logger.debug("DecodeTransformer output: "+text);
        return text;
    }
}
