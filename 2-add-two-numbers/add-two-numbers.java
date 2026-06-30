/**
 * Definition for singly-linked list.
 * public class ListNode {
 * int val;
 * ListNode next;
 * ListNode() {}
 * ListNode(int val) { this.val = val; }
 * ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        // A dummy head helps simplify the code for building the new list
        ListNode dummyHead = new ListNode(0);
        ListNode current = dummyHead;
        int carry = 0;

        // Continue looping if there are nodes left in l1 OR l2, OR if there's a leftover carry
        while (l1 != null || l2 != null || carry != 0) {
            int sum = carry;

            // Add value from l1 if it exists
            if (l1 != null) {
                sum += l1.val;
                l1 = l1.next;
            }

            // Add value from l2 if it exists
            if (l2 != null) {
                sum += l2.val;
                l2 = l2.next;
            }

            // Calculate new carry and the digit for the current position
            carry = sum / 10;
            current.next = new ListNode(sum % 10);
            current = current.next;
        }

        return dummyHead.next;
    }
}