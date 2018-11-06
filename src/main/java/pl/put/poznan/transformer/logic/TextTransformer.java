package pl.put.poznan.transformer.logic;

/**
 * This is just an example to show that the logic should be outside the REST service.
 */
public class TextTransformer {

    private final String[] transforms;

    public TextTransformer(String[] transforms){
        this.transforms = transforms;
    }

    public String transform(String text){
        // of course normally it would to something based on transforms
        return text.toUpperCase();
    }
    static String Upper(String text)
    {
	 return text.toUpperCase();
    }
    static String Lower(String text)
    {	
         return text.toLowerCase();
    }
    static String Capital(String text)
    {
          char lit[] = text.toCharArray();
	  boolean cap = true;
	  for (int i = 0; i < text.length(); i++)
	  {
	        if((lit[i] == '.')||(lit[i] == '?')||(lit[i] == '!'))
		{
		      cap = true;
		}
		else if ((cap)&&(lit[i] != ' '))
		{
			if((lit[i] >= 97) && (lit[i] <= 122))
			      lit[i]-=32;
			cap = false;
		}
	   }
	   return String.valueOf(lit);
	}
	
}
