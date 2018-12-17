package pl.put.poznan.transformer.logic.Decorators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.Decorators.UpperTransformer;

public class UpperTransformerTest {
  private UpperTransformer ut;
  
  @Before
  public void executeBeforeEach() {
    BaseTransformer bt = new BaseTransformer();
    ut = new UpperTransformer(bt);
  }

  @Test
  public void testTranformWordToUpperCase() {
    assertEquals(ut.transform("tEst"), "TEST");
  }

  @Test
  public void testTranformSentenceToUpperCase() {
    assertEquals(ut.transform("That is full sentence."), "THAT IS FULL SENTENCE.");
  }
}