/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = getLength(headA);
        int lenB = getLength(headB);

        while(lenA>lenB){
            headA = headA.next;
            lenA--;
        }
        while(lenB>lenA){
            headB = headB.next;
            lenB--;
        }

        while(headA!=null && headB!=null){
            if(headA==headB){
                return headA;
            }
            headA = headA.next;
            headB = headB.next;
        }
        return null;

    }

    int getLength(ListNode node){
        int len = 0;
        while(node!=null){
            len++;
            node = node.next;
        }
        return len;
    }
}