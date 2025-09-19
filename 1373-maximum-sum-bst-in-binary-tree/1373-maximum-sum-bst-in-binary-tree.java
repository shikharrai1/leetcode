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
 class Info{
    boolean isValid;
    int sum;
    int min;
    int max;

    // constructor
    Info(boolean isValid, int sum, int min, int max){
        this.isValid = isValid;
        this.sum = sum;
        this.min = min;
        this.max = max;
    }
 }
class Solution {
    private int Maxsum = 0;
    public int maxSumBST(TreeNode root) {
        //
            helper(root);
            return Maxsum;
    }

    // helper
    public Info helper(TreeNode root){
        // base case
        if(root == null){
            return new Info(true,0,Integer.MAX_VALUE,Integer.MIN_VALUE);
        }
     Info leftObj = helper(root.left);
     Info rightObj = helper(root.right);
     int sum = leftObj.sum+ rightObj.sum + root.val;
     int min = Math.min(root.val , Math.min(leftObj.min, rightObj.min));
     int max = Math.max(root.val, Math.max(leftObj.max, rightObj.max));

     if(leftObj.isValid && rightObj.isValid && root.val > leftObj.max && root.val < rightObj.min){
        Maxsum = Math.max(Maxsum, sum);
        return new Info(true,sum,min, max);
     } 
    else{
        return new Info(false, 0, 0, 0);
     }
    
    }

    // calcSum
    public int calcSum(TreeNode root){
        if(root == null){
            return 0;
        }
        int ls = calcSum(root.left);
        int rs = calcSum(root.right);

        return (root.val + ls + rs);
    }
}
 