package pl.put.poznan.transformer.logic;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


public interface InverseTransformer {
    Logger logger = LoggerFactory.getLogger(InverseTransformer.class);
    String transform(String text, int strt, int fnsh);
}
