package problems;

import java.util.Objects;

public class AddTwoNumbers {
    public static void main(String[] args) {
        printListNode(addTwoNumbers(new ListNode(9, new ListNode(1, new ListNode(6))), new ListNode(0)));
    }

    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        return addTwoNumbersCarry(l1, l2, 0);
    }

    public static ListNode addTwoNumbersCarry(ListNode l1, ListNode l2, int carry) {
        if (l1 == null && l2 == null) {
            return carry > 0 ? new ListNode(carry) : null;
        }

        if (l1 == null || l2 == null) {
            int val = Objects.requireNonNullElse(l1, l2).val + carry;

            if (val > 9) {
                return new ListNode(val % 10, addTwoNumbersCarry(l1 != null ? l1.next : null, l2 != null ? l2.next : null, 1));
            }
            return new ListNode(val, addTwoNumbersCarry(l1 != null ? l1.next : null, l2 != null ? l2.next : null, 0));
        }

        int val = l1.val + l2.val + carry;

        if (val > 9) {
            return new ListNode(val % 10, addTwoNumbersCarry(l1.next, l2.next, 1));
        }
        return new ListNode(val, addTwoNumbersCarry(l1.next, l2.next, 0));
    }

    public static void printListNode(ListNode l) {
        if (l.next == null) {
            System.out.print(l.val);
        } else {
            System.out.print(l.val + ", ");
            printListNode(l.next);
        }
    }

    // Definition for singly-linked list.
    public static class ListNode {
        int val;
        ListNode next;
        ListNode() {}
        ListNode(int val) { this.val = val; }
        ListNode(int val, ListNode next) { this.val = val; this.next = next; }
    }
}