package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.CipherTransformer;

import javax.crypto.Cipher;

/**
 * Created by Michal on 15.12.2018.
 */
public class EncodeTransformer extends Decorator  {
    private CipherTransformer dt;

    public EncodeTransformer(TextTransformer decorator, CipherTransformer dt) {
        super(decorator);
        this.dt = dt;
    }

    /**
     * This function is used for encrypt string.
     * @param text - Input string that will be changed
     * @return string where encrypted
     */
    @Override
    public String transform(String text){
        logger.debug("EncodeTransformer input: "+text);
        text = super.transform(text);
        text = dt.transform(text);
        logger.debug("EncodeTransformer output: "+text);
        return text;
    }
}
