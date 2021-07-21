package test;

import amazonQuestion.ReorderLogFiles;
import org.junit.Test;

import java.util.Arrays;

public class tc_ReorderLogFiles {

  @Test
  public void tc_0() {
    ReorderLogFiles executor = new ReorderLogFiles();
    System.out.println(Arrays.toString(executor.reorderLogFiles(new String[]{"dig1 8 1 5 1", "let1 art can", "dig2 3 6", "let2 own kit dig", "let3 art zero"})));

  }
}
