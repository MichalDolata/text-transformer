package pl.put.poznan.transformer.logic.Decorators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.Decorators.EncodeTransformer;
import pl.put.poznan.transformer.logic.Decorators.DecodeTransformer;


public class EncodeTransformerTest {
  private EncodeTransformer et;
  private DecodeTransformer dt;

  @Before
  public void executeBeforeEach() {
    BaseTransformer bt = new BaseTransformer();
    et = new EncodeTransformer(bt);
    dt = new DecodeTransformer(bt);
  }

  @Test
  public void testCorrectlyEncodeSingleWorld() {
    String encoded = et.transform("word");
    assertEquals("word", dt.transform(encoded));
  }

  @Test
  public void testCorrectlyEncodeASentens() {
    String encoded = et.transform("A short sentence.");
    assertEquals("A short sentence.", dt.transform(encoded));
  }

  @Test
  public void testCorrectlyEncodeUTFCharacters() {
    String encoded = et.transform("bałwan");
    assertEquals("bałwan", dt.transform(encoded));
  }
}