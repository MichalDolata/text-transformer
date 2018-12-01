package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;


public class UpperTransformer extends Decorator {

    public UpperTransformer(TextTransformer decorator){
        super(decorator);
    }
    /**
     * This function is used for transformation all letters to upper case.
     * @param text - Input string that will be changed
     * @return string where all letters in upper case
     */
    @Override
    public String transform(String text){
        logger.debug("UpperTransformer input: "+text);
        text = super.transform(text);
        text = text.toUpperCase();
        logger.debug("UpperTransformer output: "+text);
        return text;
    }
}

