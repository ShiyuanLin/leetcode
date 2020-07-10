package test;

import implementation.LongestPalindrome;
import org.junit.Assert;
import org.junit.Test;

public class tc_LongestPalindrome {
  @Test
  public void tc_1() {
    String s = "bcacbad";
    String o = "bcacb";
    String res = LongestPalindrome.solution(s);
    Assert.assertEquals(o, res);
  }

  @Test
  public void tc_2() {
    String s = "cbbd";
    String o = "bb";
    String res = LongestPalindrome.solution(s);
    Assert.assertEquals(o, res);
  }

  @Test
  public void tc_3() {
    String s = "a";
    String o = "a";
    String res = LongestPalindrome.solution(s);
    Assert.assertEquals(o, res);
  }

  @Test
  public void tc_4() {
    String s = "bb";
    String o = "bb";
    String res = LongestPalindrome.solution(s);
    Assert.assertEquals(o, res);
  }
}
