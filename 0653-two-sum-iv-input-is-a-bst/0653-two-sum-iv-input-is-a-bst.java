/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public boolean findTarget(TreeNode root, int k) {
        List<Integer> list = new ArrayList<>();
        getInorder(root,list);
       int n = list.size();
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(list.get(i) + list.get(j) == k){
                    return true;
                }
            }
        }
        return false;
    }
    // getInorder
    public void getInorder(TreeNode root, List<Integer> list){
        if(root == null){
            return;
        }
        getInorder(root.left, list);
        list.add(root.val);
        getInorder(root.right, list);
    }
}