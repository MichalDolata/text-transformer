package pl.put.poznan.transformer.logic.Decorators.Map;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.Decorators.Map.LatexTransformer;

public class LatexTransformerTest {
  private LatexTransformer lt;

  @Before
  public void executeBeforeEach() {
    BaseTransformer bt = new BaseTransformer();
    lt = new LatexTransformer(bt);
  }

  @Test
  public void testEscapesGivenCharacters() {
    assertEquals("Test \\textgreater no test", lt.transform("Test > no test"));
  }
}