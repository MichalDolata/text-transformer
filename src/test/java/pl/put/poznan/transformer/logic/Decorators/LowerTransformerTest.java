package pl.put.poznan.transformer.logic.Decorators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.Decorators.LowerTransformer;

public class LowerTransformerTest {
  private LowerTransformer lt;

  @Before
  public void executeBeforeEach() {
    BaseTransformer bt = new BaseTransformer();
    lt = new LowerTransformer(bt);
  }

  @Test
  public void testTranformWordToLowerCase() {
    assertEquals(lt.transform("TeST"), "test");
  }

  @Test
  public void testTranformSentenceToLowerCase() {
    assertEquals(lt.transform("THAT IS FULL SENTENCE."), "that is full sentence.");
  }
  @Test
  public void testTranformEmpty() {
    assertEquals(lt.transform(""), "");
  }

  @Test
  public void testTranformSentenceFromLowerCase() {
    assertEquals(lt.transform("that is full sentence."), "that is full sentence.");
  }
  @Test
  public void testTranformCharToLowerCase() {
    assertEquals(lt.transform("T"), "t");
  }


}