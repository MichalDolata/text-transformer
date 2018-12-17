package pl.put.poznan.transformer.logic.Decorators.Map;

import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Collections;
import java.util.HashMap;

public class TextToAbbrevivationTransformer extends MapTransformer {
    public TextToAbbrevivationTransformer(TextTransformer decorator){
        super(decorator);

        /**
         * Map used to replace sequence of words to corresponding abbreviation
         */
        map = Collections.unmodifiableMap(
                new HashMap<String,String>(){{
                    put("profesor","prof.");
                    put("Profesor","Prof.");
                    put("doktor", "dr");
                    put("Doktor", "Dr");
                    put("na przykład", "np.");
                    put("Na przykład", "Np.");
                    put("i tym podobne", "itp.");
                    put("I tym podobne", "Itp.");
                    put("między innymi", "m.in");
                    put("Między innymi", "M.in");
                }}
        );

    }
}
