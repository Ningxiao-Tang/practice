package Recursion;

public class SwapNodesPairs {
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode first = head;
        ListNode second = head.next;

        //swapping
        first.next = swapPairs(second.next);
        second.next = first;

        return second;
    }
}
