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
            //     // check is size of LL is 1 so we will delete that 
        if(head.next == null) return head.next;
        int len = getLen(head);
        int mid = len/2;
    //     // in order to delete the middle node we have to reach a node that is just before the middle node 
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

    // // getLen()
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

    //-----------------Optimal App----------------------------
    // using slow fast technique;
    // base case
    // if(head.next == null) return head.next;
    // ListNode slow = head;
    // ListNode fast = head;
    // ListNode prev = head;
    // // find the mid node
    // while(fast != null && fast.next != null){
    //     prev = slow;
    //     slow = slow.next;
    //     fast = fast.next.next;
    // }
    // // now when the slow is pointing at the mid node the prev pointer will be pointing to a node just before this mid node
    // prev.next = prev.next.next;
    // return head;
// }
}