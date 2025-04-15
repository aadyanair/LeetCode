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
        if (k == 0 ||head==null || head.next==null) return head;
        int len =1;
        ListNode cur = head;

        while(cur.next!=null){
            len = len+1;
            cur = cur.next;
        }
        cur.next = head; //convert to circular LL
        k = k%len; //for cases k value more than length
        ListNode temp = head;
        for(int i=1; i<(len-k);i++){
            temp = temp.next;
        }
        head = temp.next;
        temp.next = null;
        return head;
        
    }
}