package test;

import implementation.AddTwoNumbers;
import model.ListNode;
import org.junit.Assert;
import org.junit.Test;

public class tc_AddTwoNumbers {
    @Test
    public void tc_1() {
        ListNode inputOne = new ListNode(2);
        inputOne.setNext(new ListNode(4));
        inputOne.getNext().setNext(new ListNode(3));

        ListNode inputTwo = new ListNode(5);
        inputTwo.setNext(new ListNode(6));
        inputTwo.getNext().setNext(new ListNode(4));

        ListNode expectedResult = new ListNode(7);
        expectedResult.setNext(new ListNode(0));
        expectedResult.getNext().setNext(new ListNode(8));

        ListNode res = AddTwoNumbers.solution(inputOne, inputTwo);
        Assert.assertEquals(expectedResult, res);
    }
}
