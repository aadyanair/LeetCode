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
        }
        return prev;
    }
    public void reorderList(ListNode head) {
        ListNode slow = head, fast = head;
        while(fast.next!=null && fast.next.next != null){
            slow = slow.next; 
            fast = fast.next.next;
        }
        ListNode secondHalf = slow.next;
        slow.next = null;
        secondHalf = rev(secondHalf);
        mergeList(head,secondHalf);
    }

    public void mergeList(ListNode list1, ListNode list2){
        while(list1!=null && list2 != null){
            ListNode temp1 = list1.next;
            ListNode temp2 = list2.next;

            list1.next = list2;
            if(temp1 == null) break;
            list2.next = temp1;

            list1 = temp1;
            list2 = temp2;
        }
    }
}