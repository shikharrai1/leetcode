/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode curr = node;
        ListNode next = curr.next;
        curr.val = next.val;
        curr.next = next.next;
        next.next = null;
    }
}