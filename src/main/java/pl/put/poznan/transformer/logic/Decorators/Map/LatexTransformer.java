package pl.put.poznan.transformer.logic.Decorators.Map;

import pl.put.poznan.transformer.logic.TextTransformer;

import java.util.Collections;
import java.util.HashMap;

public class LatexTransformer extends MapTransformer {
    public LatexTransformer(TextTransformer decorator){
        super(decorator);
        /**
         * Map used to replace special LaText characters.
         */
        map = Collections.unmodifiableMap(
                new HashMap<String,String>() {{
                    put("\\%","\\\\%");
                    put("\\$","\\\\"+"\\$");
                    put("\\{","\\\\{");
                    put("\\}","\\\\}");
                    put("_","\\\\_");
                    put("\\|","\\\\textbar");
                    put(">","\\\\textgreater");
                    put("<","\\\\textbackslash");
                    put("\\&","\\\\&");
                }});

    }

}
