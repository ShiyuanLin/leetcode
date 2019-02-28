package model;

import java.util.Objects;

public class ListNode {
    public int val;
    public ListNode next;

    public ListNode(int x)
    {
        val = x;
        next = null;
    }

    public int getVal() {
        return val;
    }

    public void setVal(int val) {
        this.val = val;
    }


    public ListNode getNext() {
        return next;
    }

    public void setNext(ListNode next) {
        this.next = next;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ListNode listNode = (ListNode) o;
        return val == listNode.val &&
                Objects.equals(next, listNode.next);
    }

    @Override
    public String toString() {
        if (next == null) {
            return Integer.toString(val);
        } else {
            return val + " -> " + next.toString();
        }
    }
}
