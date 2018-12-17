package pl.put.poznan.transformer.logic.Decorators.Map;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.Decorators.Map.AbbrevivationToTextTransformer;

public class AbbrevivationToTextTransformerTest {
  private AbbrevivationToTextTransformer att;

  @Before
  public void executeBeforeEach() {
    BaseTransformer bt = new BaseTransformer();
    att = new AbbrevivationToTextTransformer(bt);
  }

  @Test
  public void testChangesAbbreviationAtTheBeginningOfText() {
    assertEquals("Doktor Janas.", att.transform("Dr Janas."));
  }

  @Test
  public void testChangesAbbreviationAtTheEndOfText() {
    assertEquals("to jest nasz profesor", att.transform("to jest nasz prof."));
  }

  @Test
  public void testChangesAbbreviationInTheMiddleOfText() {
    assertEquals("to i tym podobne rzeczy", att.transform("to itp. rzeczy"));
  }
}