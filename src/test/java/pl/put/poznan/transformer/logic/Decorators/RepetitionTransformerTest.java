package pl.put.poznan.transformer.logic.Decorators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.Decorators.RepetitionTransformer;

public class RepetitionTransformerTest {
  private RepetitionTransformer rt;

  @Before
  public void executeBeforeEach() {
    BaseTransformer bt = new BaseTransformer();
    rt = new RepetitionTransformer(bt);
  }

  @Test
  public void testRemovesRepetitionAtTheBeginningOfSentence() {
    assertEquals("Double at the start.", rt.transform("Double double at the start."));
  }

  @Test
  public void testRemovesRepetitionAtTheEndOfSentence() {
    assertEquals("At the end.", rt.transform("At the end end."));
  }

  @Test
  public void testRemovesRepetitionInTheMiddleOfSentence() {
    assertEquals("In the middle.", rt.transform("In the the middle."));
  }

  @Test
  public void testRemovesMultipleRepetitionInASentence() {
    assertEquals("One two three.", rt.transform("One one two two two three."));
  }
}