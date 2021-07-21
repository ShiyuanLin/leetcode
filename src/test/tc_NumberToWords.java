package test;

import amazonQuestion.NumberToWords;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class tc_NumberToWords {
  @Test
  public void tc_0() {
    NumberToWords executor = new NumberToWords();
    Assert.assertEquals("Twelve Thousand Three Hundred Forty Five", executor.numberToWords(12345));
  }
}
