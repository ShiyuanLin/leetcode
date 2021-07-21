package amazonQuestion;

import model.ListNode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MergeKLists {
  public ListNode mergeKLists(ListNode[] lists) {
    ListNode res = new ListNode(0);
    ListNode curr = res;
    List<ListNode> arrayLists = new ArrayList<>();
    for (ListNode element: lists) {
      if (element != null) {
        arrayLists.add(element);
      }
    }

    while (arrayLists.size() > 0) {
      int minValue = Integer.MAX_VALUE;
      int minIdx = 0;

      for (int i = 0; i < arrayLists.size(); i++) {
        if (arrayLists.get(i).val < minValue) {
          minValue = arrayLists.get(i).val;
          minIdx = i;
        }
      }

      curr.next = arrayLists.get(minIdx);
      curr = curr.next;

      if (arrayLists.get(minIdx).next == null) {
        arrayLists.remove(minIdx);
      } else {
        arrayLists.set(minIdx, arrayLists.get(minIdx).next);
      }
    }
    return res.next;
  }
}
