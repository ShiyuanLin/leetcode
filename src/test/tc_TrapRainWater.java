package test;

import amazonQuestion.TrapRainWater;
import org.junit.Test;

public class tc_TrapRainWater {
  @Test
  public void tc_0() {
    TrapRainWater executor = new TrapRainWater();
    int[] height = new int[] {0,1,0,2,1,0,1,3,2,1,2,1};

    System.out.println(executor.trap(height));
  }

  @Test
  public void tc_1() {
    TrapRainWater executor = new TrapRainWater();
    int[] height = new int[] {2,0,2};

    System.out.println(executor.trap(height));
  }
}
