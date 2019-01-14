package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import pl.put.poznan.transformer.logic.Decorators.*;
import pl.put.poznan.transformer.logic.Decorators.Map.AbbrevivationToTextTransformer;
import pl.put.poznan.transformer.logic.Decorators.Map.LatexTransformer;
import pl.put.poznan.transformer.logic.Decorators.Map.TextToAbbrevivationTransformer;
//import javax.validation.constraints.Null;
//import java.util.*;


public interface TextTransformer {
    Logger logger = LoggerFactory.getLogger(TextTransformer.class);
    String transform(String text);

    static Decorator getTransformerByName(String name, TextTransformer tt){
        Decorator res = null;
        switch (name){
            case "latex":
                res = new LatexTransformer(tt);
                break;
            case "upper":
                res = new UpperTransformer(tt);
                break;
            case "capitalize":
                res = new CapitalizeTransformer(tt);
                break;
            case "repetition":
                res = new RepetitionTransformer(tt);
                break;
            case "abbrevivationtotext":
                res = new AbbrevivationToTextTransformer(tt);
                break;
            case "texttoabbrevivation":
                res = new TextToAbbrevivationTransformer(tt);
                break;
            case "decode":
                res = new DecodeTransformer(tt);
                break;
            case "encode":
                res = new EncodeTransformer(tt);
                break;
            case "inverse":
                res = new InverseTransformer(tt);
                break;
            case "lower":
                res = new LowerTransformer(tt);
                break;
        }
        return res;
    }
}
