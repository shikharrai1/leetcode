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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        // if head is null
        if(head == null) return head;
        // if n is equal to the length of ll deleting nth from end means deleting 1st from start
        int len = getLength(head);
        if(len == n){
            return head.next;
        }
        // in rest of the cases
        ListNode prev = head;
        int cnt = 1;
        int toDelFromSt = len-n+1;
        while(cnt < toDelFromSt-1){
            prev = prev.next;
            cnt++;
        }
          prev.next = prev.next.next;
          return head;
    }

    // getLength()
    int getLength(ListNode head){
        if(head == null){
            return 0;
        }
        // otherwise some valid length
        int cnt = 0;
        ListNode temp = head;
        while(temp != null){
            cnt++;
            temp = temp.next;
        }
        return cnt;
    }
}