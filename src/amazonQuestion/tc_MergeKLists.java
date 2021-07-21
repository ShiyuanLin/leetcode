package amazonQuestion;

import model.ListNode;
import org.junit.Test;

public class tc_MergeKLists {
  @Test
  public void tc_0() {
    MergeKLists executor = new MergeKLists();
    ListNode[] lists = new ListNode[] {};
    executor.mergeKLists(lists);
  }
}
