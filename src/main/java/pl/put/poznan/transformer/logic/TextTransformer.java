package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.crypto.Cipher;
import pl.put.poznan.transformer.logic.Decorators.*;
import pl.put.poznan.transformer.logic.Decorators.Map.AbbrevivationToTextTransformer;
import pl.put.poznan.transformer.logic.Decorators.Map.LatexTransformer;
import pl.put.poznan.transformer.logic.Decorators.Map.TextToAbbrevivationTransformer;
//import javax.validation.constraints.Null;
//import java.util.*;
import pl.put.poznan.transformer.logic.CipherTransformer;


public interface TextTransformer {
    Logger logger = LoggerFactory.getLogger(TextTransformer.class);
    String transform(String text);

    static Decorator getTransformerByName(String name, TextTransformer tt){
        Decorator res = null;
        CipherTransformer dt = null;
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
                dt = new CipherTransformer(Cipher.DECRYPT_MODE);
                res = new DecodeTransformer(tt, dt);
                break;
            case "encode":
                dt = new CipherTransformer(Cipher.ENCRYPT_MODE);
                res = new EncodeTransformer(tt, dt);
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
