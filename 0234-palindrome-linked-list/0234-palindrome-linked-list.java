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

    ListNode rev(ListNode head){
        ListNode cur = head;
        ListNode prev = null;
        ListNode next = null;

        while(cur!=null){
            next = cur.next;
            cur.next = prev;
            prev = cur;
            cur = next;
        }return prev;
    }


    public boolean isPalindrome(ListNode head) {
        ListNode slow =head,fast=head;
        while(fast.next!=null && fast.next.next!=null ){
            slow = slow.next;
            fast = fast.next.next;

        }

        ListNode secondHalf = slow.next;
        slow.next = null;
        secondHalf = rev(secondHalf);
        while(secondHalf!=null){
            if(head.val!=secondHalf.val){
                return false;
            }

            head = head.next;
            secondHalf = secondHalf.next;
        }
        return true;
    }
}