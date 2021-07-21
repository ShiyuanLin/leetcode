package test;

import amazonQuestion.MostCommonWord;
import org.junit.Assert;
import org.junit.Test;

public class tc_MostCommonWord {

  @Test
  public void tc_0() {
    MostCommonWord excutor = new MostCommonWord();
    String para = "Bob. hIt, baLl";
    String[] banned = new String[] {"bob", "hit"};

    Assert.assertEquals("ball", excutor.mostCommonWord(para, banned));
  }
}
