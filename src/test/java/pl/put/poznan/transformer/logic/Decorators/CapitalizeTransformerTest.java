package pl.put.poznan.transformer.logic.Decorators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.Decorators.CapitalizeTransformer;

public class CapitalizeTransformerTest {
  private CapitalizeTransformer ct;

  @Before
  public void executeBeforeEach() {
    BaseTransformer bt = new BaseTransformer();
    ct = new CapitalizeTransformer(bt);
  }

  @Test
  public void testCapitalizeFirstWordOfEachSentence() {
    assertEquals(ct.transform("first Sentence. Second sentence."), "First Sentence. Second sentence.");
  }

  @Test
  public void testCapitalizeOnlyAfterDots() {
    assertEquals(ct.transform("sentence. sentence, not sentence"), "Sentence. Sentence, not sentence");
  }

  @Test
  public void testCapitalizeEmpty() {
    assertEquals(ct.transform(""), "");
  }

  @Test
  public void testCapitalizeNumbers() {
    assertEquals(ct.transform("123a"), "123a");
  }

  @Test
  public void testCapitalizeUpper() {
    assertEquals(ct.transform("ALA MA KOTA. KOTA MA ALE."), "ALA MA KOTA. KOTA MA ALE.");
  }



}