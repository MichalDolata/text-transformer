package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
//import javax.validation.constraints.Null;
//import java.util.*;


public interface TextTransformer {
    Logger logger = LoggerFactory.getLogger(TextTransformer.class);
    String transform(String text);
}
