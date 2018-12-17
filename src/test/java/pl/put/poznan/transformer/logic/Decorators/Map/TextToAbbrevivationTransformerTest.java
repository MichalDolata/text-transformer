package pl.put.poznan.transformer.logic.Decorators.Map;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.Decorators.Map.TextToAbbrevivationTransformer;

public class TextToAbbrevivationTransformerTest {
  private TextToAbbrevivationTransformer tta;

  @Before
  public void executeBeforeEach() {
    BaseTransformer bt = new BaseTransformer();
    tta = new TextToAbbrevivationTransformer(bt);
  }

  @Test
  public void testChangesTextToAbbreviationAtTheBeginning() {
    assertEquals("Dr Janas.", tta.transform("Doktor Janas."));
  }

  @Test
  public void testChangesTextToAbbreviationAtTheEnd() {
    assertEquals("to jest nasz prof..", tta.transform("to jest nasz profesor."));
  }

  @Test
  public void testChangesTextToAbbreviationInTheMiddle() {
    assertEquals("to itp. rzeczy", tta.transform("to i tym podobne rzeczy"));
  }
}