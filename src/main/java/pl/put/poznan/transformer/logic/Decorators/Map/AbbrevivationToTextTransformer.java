package pl.put.poznan.transformer.logic.Decorators.Map;

import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Collections;
import java.util.HashMap;

public class AbbrevivationToTextTransformer extends MapTransformer {
    public AbbrevivationToTextTransformer(TextTransformer decorator)
    {
        super(decorator);

        this.map = Collections.unmodifiableMap(
                new HashMap<String,String>(){{
                    put("\\bprof\\b.", "profesor");
                    put("\\bProf\\b.", "Profesor");
                    put("\\bdr\\b", "doktor");
                    put("\\bDr\\b", "Doktor");
                    put("\\bnp\\b\\.", "na przykład");
                    put("\\bNp\\b\\.", "Na przykład");
                    put("\\bitd\\b\\.", "i tym podobne");
                    put("\\bItd\\b\\.", "I tym podobne");
                    put("\\bm\\.in\\b", "między innymi");
                    put("\\bM\\.in\\b", "Między innymi");
                }}
        );
    }
}
