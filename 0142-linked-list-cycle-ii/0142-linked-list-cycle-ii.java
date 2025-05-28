/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        ListNode i = head, j=head;
        while(j!=null && j.next!=null){
            i = i.next;
            j = j.next.next;
            if(i==j) {
                ListNode entry = head;
                while(entry!=i){
                    entry = entry.next;
                    i = i.next;
                }
                return entry;
            }
        }
        return null;
    }
}