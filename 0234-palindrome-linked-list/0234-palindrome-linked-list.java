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
    public boolean isPalindrome(ListNode head) {
        //Find Middle
        ListNode slow=head;
        ListNode fast=head;
        while(fast!=null && fast.next!=null){
            slow=slow.next;
            fast=fast.next.next;
        }
        //Reverse from middel
        ListNode prev=null;
        ListNode current=slow;
        while(current!=null){
            ListNode next=current.next;
            current.next=prev;
            prev=current;
            current=next;
        }
        ListNode first=head;
        ListNode second=prev;

        //compare
        while(second!=null){
            if(second.val!=first.val){
                return false;
            }
            first=first.next;
            second=second.next;
        }
        return true;
    }
}