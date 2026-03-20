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
    public boolean hasCycle(ListNode head) {
        //--------------------App1-----------------------------------
        // HashMap<ListNode, Integer> map = new HashMap<>();
        // ListNode temp = head;
        // while(temp != null){
        //     if(map.containsKey(temp)) return true;
        //     map.put(temp, 1);
        //     temp = temp.next;
        // }
        // return false;

        //---------------------------- Optimal Sol --------------------
        if(head == null) return false;
        ListNode slow = head;
        ListNode fast = head;
        while(fast.next != null && fast != null){
            fast = fast.next.next;
            slow = slow.next;

            if(fast == slow) return true;

            if(fast == null || fast.next == null) return false;

        } 
        return false;
    }
}
