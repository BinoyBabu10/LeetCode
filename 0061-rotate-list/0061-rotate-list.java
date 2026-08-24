/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode rotateRight(ListNode head, int k) {

        // Empty list or only one node
        if (head == null || head.next == null || k == 0) {
            return head;
        }

        // Find length and tail
        int length = 1;
        ListNode tail = head;

        while (tail.next != null) {
            tail = tail.next;
            length++;
        }

        // Reduce k
        k = k % length;

        // No rotation needed
        if (k == 0) {
            return head;
        }

        // Make circular
        tail.next = head;

        // Find new tail
        ListNode newTail = head;

        for (int i = 0; i < length - k - 1; i++) {
            newTail = newTail.next;
        }

        // New head is after new tail
        ListNode newHead = newTail.next;

        // Break circle
        newTail.next = null;

        return newHead;
    }
}