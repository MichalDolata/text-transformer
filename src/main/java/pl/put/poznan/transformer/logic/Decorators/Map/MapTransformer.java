package pl.put.poznan.transformer.logic.Decorators.Map;

import pl.put.poznan.transformer.logic.TextTransformer;
import pl.put.poznan.transformer.logic.Decorators.Decorator;

import java.util.Map;

class MapTransformer extends Decorator {
    /**
     * Map used to replace abbreviation to long forms.
     */
    protected Map<String,String> map;

    public MapTransformer(TextTransformer decorator){
        super(decorator);
    }

    /**
     *  This function replaces all occurrence of words in map keys with map value.
     * @param text
     * @return
     */
    @Override
    public String transform(String text){
        logger.debug("MapTransformer input: "+text);
        text = super.transform(text);
        for (Map.Entry<String, String> entry : map.entrySet())
        {
            text = text.replaceAll(entry.getKey(),entry.getValue());
        }
        logger.debug("MapTransformer output: "+text);
        return text;
    }
}
