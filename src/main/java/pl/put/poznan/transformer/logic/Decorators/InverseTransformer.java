package pl.put.poznan.transformer.logic.Decorators;

import pl.put.poznan.transformer.logic.TextTransformer;

public class InverseTransformer extends Decorator {
    public InverseTransformer(TextTransformer decorator){
        super(decorator);
    }
    /**
     * This function is used for inversing text on chosen position.
     * @param text - Input string that will be changed
     * @param strt - Start position
     * @param fnsh - End position
     * @return string with inversed text on chosen position
     */
    @Override
    public String transform(String text){
        logger.debug("InverseTransformer input: "+text);
        text = super.transform(text);
        char lit[] = text.toCharArray();

        char tmp;
		    int i = 0;
		    int j = text.size();
		    while(i < j) {
			    tmp = lit[i];
			    lit[i] = lit[j];
			    lit[j] = tmp;
			    i++;
			    j--;		
		    }
        logger.debug("InverseTransformer output: "+String.valueOf(lit));
        return String.valueOf(lit);
    }

}
