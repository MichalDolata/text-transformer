package pl.put.poznan.transformer.logic.Decorators;

import static org.junit.Assert.assertEquals;

import org.junit.Before;
import org.junit.Test;
import static org.mockito.Mockito.*;

import javax.crypto.Cipher;

import pl.put.poznan.transformer.logic.BaseTransformer;
import pl.put.poznan.transformer.logic.Decorators.EncodeTransformer;
import pl.put.poznan.transformer.logic.Decorators.DecodeTransformer;
import pl.put.poznan.transformer.logic.CipherTransformer;


public class EncodeTransformerTest {
  private EncodeTransformer et;
  private DecodeTransformer dt;

  @Before
  public void executeBeforeEach() {
    BaseTransformer bt = new BaseTransformer();
    CipherTransformer ct = new CipherTransformer(Cipher.ENCRYPT_MODE);
    et = new EncodeTransformer(bt, ct);
    ct = new CipherTransformer(Cipher.DECRYPT_MODE);
    dt = new DecodeTransformer(bt, ct);
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

  @Test
  public void testCorrectlyEncodeEmpty() {
    String encoded = et.transform("");
    assertEquals("", dt.transform(encoded));
  }

  @Test
  public void testCorrectlyEncodeLongWord() {
    String encoded = et.transform("bałwanalasdaasdgadasfadsfasdfdsaasfsdfasdfadsfasdf");
    assertEquals("bałwanalasdaasdgadasfadsfasdfdsaasfsdfasdfadsfasdf", dt.transform(encoded));
  }

  @Test
  public void testCorrectCallingCipherTransformerForDecode() {
    CipherTransformer mockedCT = mock(CipherTransformer.class);

    BaseTransformer bt = new BaseTransformer();
    dt = new DecodeTransformer(bt, mockedCT);
    dt.transform("stringtodecode");

    verify(mockedCT).transform("stringtodecode");
  }

  @Test
  public void testCorrectCallingCipherTransformerForEncode() {
    CipherTransformer mockedCT = mock(CipherTransformer.class);

    BaseTransformer bt = new BaseTransformer();
    et = new EncodeTransformer(bt, mockedCT);
    et.transform("stringtoencode");

    verify(mockedCT).transform("stringtoencode");
  }

  @Test
  public void testCorrectReturningValueFromCipherTransformerForDecode() {
    CipherTransformer mockedCT = mock(CipherTransformer.class);

    BaseTransformer bt = new BaseTransformer();
    dt = new DecodeTransformer(bt, mockedCT);

    when(mockedCT.transform("stringtodecode")).thenReturn("stringdecoded");

    assertEquals("stringdecoded", dt.transform("stringtodecode")); 
  }

  @Test
  public void testCorrectReturningValueFromCipherTransformerForEncode() {
    CipherTransformer mockedCT = mock(CipherTransformer.class);

    BaseTransformer bt = new BaseTransformer();
    et = new EncodeTransformer(bt, mockedCT);
    et.transform("stringtoencode");

    when(mockedCT.transform("stringtoencode")).thenReturn("stringencoded");

    assertEquals("stringencoded", et.transform("stringtoencode")); 
  }
}