package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;

public class CapitalizeTransformer extends Decorator {
    public CapitalizeTransformer(TextTransformer decorator){
        super(decorator);
    }
    /**
     * This function is used for transformation onle the first letter in each sentence to upper case.
     * @param text - Input string that will be changed
     * @return string where onle the first letter in each sentence in upper case
     */
    @Override
    public String transform(String text){
        logger.debug("CapitalizeTransformer input: "+text);
        text = super.transform(text);
        char lit[] = text.toCharArray();

        boolean cap = true;
        for (int i = 0; i < text.length(); i++){
            if((lit[i] == '.')||(lit[i] == '?')||(lit[i] == '!')){
                cap = true;
            }else if ((cap)&&(lit[i] != ' ')){
                if((lit[i] >= 97) && (lit[i] <= 122))
                    lit[i]-=32;
                cap = false;
            }
        }
        logger.debug("CapitalizeTransformer output: "+String.valueOf(lit));
        return String.valueOf(lit);
    }

}
