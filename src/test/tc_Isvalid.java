package test;

import implementation.IsValid;
import org.junit.Assert;
import org.junit.Test;

public class tc_Isvalid {
  @Test
  public void tc_0(){
    boolean res = IsValid.solution("[");
    Assert.assertEquals(false, res);
  }

  @Test
  public void tc_1(){
    boolean res = IsValid.solution("()");
    Assert.assertEquals(true, res);
  }

  @Test
  public void tc_2(){
    boolean res = IsValid.solution("()[]{}");
    Assert.assertEquals(true, res);
  }

  @Test
  public void tc_3(){
    boolean res = IsValid.solution("(]");
    Assert.assertEquals(false, res);
  }

  @Test
  public void tc_4(){
    boolean res = IsValid.solution("([)]");
    Assert.assertEquals(false, res);
  }

  @Test
  public void tc_5(){
    boolean res = IsValid.solution("{[]}");
    Assert.assertEquals(true, res);
  }

  @Test
  public void tc_6(){
    boolean res = IsValid.solution("][");
    Assert.assertEquals(false, res);
  }
}
