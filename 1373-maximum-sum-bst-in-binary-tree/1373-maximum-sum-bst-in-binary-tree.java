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
 //----------------------------App1------------------------------------
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

// ------------------------------App2-------------------------------
class Infoo{
    int size;
    int max; 
    int min;

    // constructor
    Infoo(int size, int max, int min){
        this.size = size;
        this.max = max;
        this.min = min;
    }
}
class Solution {
   
    private int Maxsum = 0;
    public int maxSumBST(TreeNode root) {
    //      //---------------------------App1--------------------------
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
     
    //  Infoo i = helper(root);
    //  return i.size;
    }

    // // helper
    // public Infoo helper(TreeNode root){
    //     //
    //     if(root == null){
    //         return new Infoo(0,Integer.MIN_VALUE,Integer.MAX_VALUE);
    //     }
    //     Infoo left = helper(root.left);
    //     Infoo right = helper(root.right);

    //     int size = left.size + right.size + 1;
    //     int max = Math.max(root.val, Math.max(left.max, right.max));
    //     int min = Math.min(root.val, Math.min(left.min, right.min));

    //     if(left.max < root.val && root.val < right.min){
    //         return new Infoo(size, max, min);
    //     }else{
    //         int sizeee = Math.max(left.size, right.size);
    //         return new Infoo(sizeee, Integer.MAX_VALUE, Integer.MIN_VALUE);
    //     }
    // }
}
 