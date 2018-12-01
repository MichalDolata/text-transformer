package pl.put.poznan.transformer.logic;

public class BaseTransformer implements TextTransformer {
    public String transform(String text){
        logger.debug("BaseTransformer input/output: "+text);
        return text;
    }
}
