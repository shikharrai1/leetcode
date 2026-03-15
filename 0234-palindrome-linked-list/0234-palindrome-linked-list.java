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
    public boolean isPalindrome(ListNode head) {
        // base case when ll is empty or has size equal to 1
        if(head == null || head.next == null) return true;
        
        List<Integer> list = new ArrayList<>();
        ListNode temp = head;
        while(temp != null){
            list.add(temp.val);
            temp = temp.next;
        }
        // now do a traversal on this ll using 2 pointer approach
        int start = 0;
        int end = list.size()-1;
        while(start < end){
            if(list.get(start) != list.get(end)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}