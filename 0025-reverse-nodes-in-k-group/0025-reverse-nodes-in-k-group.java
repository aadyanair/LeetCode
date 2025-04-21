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
        return head;
    }

    ListNode getKthNode(ListNode head,int k){
        k-=1;
        while(head!=null && k>0){
            k--;
            head = head.next;
        }
        return head;
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode temp = head;
        ListNode prevLast = null;
        while(temp!=null){
            ListNode kThNode = getKthNode(temp,k);

            if(kThNode == null){
                if(prevLast!=null){
                    prevLast.next = temp;
                }
                break;
            }

            ListNode nextNode = kThNode.next;

            kThNode.next=null;

            rev(temp);

            if(temp==head){
                head = kThNode;
            }else{
                prevLast.next = kThNode;
            }

            prevLast = temp;
            temp = nextNode;
        }
        return head;

    }

    static void printLL(ListNode head){
        ListNode temp = head;
        while(temp!=null){
            System.out.print(temp.val+" ");
            temp = temp.next;
        }
        System.out.println();
    }

}