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
    public ListNode deleteMiddle(ListNode head) {
        // ----------------------App1----------------------
        // first find the length of the ll then divide that length by two to find the mid and then traverse upto the mid node
        
        int len = getLen(head);
        // check is size of LL is 1 so we will delete that 
        if(len == 1) return head.next;
        int mid = len/2;
        // in order to delete the middle node we have to reach a node that is just before the middle node 
        int nodeToReach = mid-1;
        int cnt = 0;
        ListNode prev = head;
        while(cnt < nodeToReach){
            prev = prev.next;
            cnt++;
        }
        prev.next = prev.next.next;
        return head;
    }

    // getLen()
    int getLen(ListNode head){
        // base case
        if(head == null) return 0;
        ListNode temp = head;
        int len = 0;
        while(temp != null){
            len++;
            temp = temp.next;
        }
        return len;
    }
}