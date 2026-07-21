class Solution {
    public ListNode swapPairs(ListNode head) {
        // Dummy node to handle edge cases easily
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            ListNode first = prev.next;
            ListNode second = prev.next.next;

            // Swapping the pointers
            first.next = second.next;
            second.next = first;
            prev.next = second;

            // Move prev two steps forward
            prev = first;
        }

        return dummy.next;
    }
}