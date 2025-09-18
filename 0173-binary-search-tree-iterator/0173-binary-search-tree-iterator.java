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
class BSTIterator {
// static int temp = 0;
// static List<Integer> inorder = new ArrayList<>();
private Stack<TreeNode> stack = new Stack<TreeNode>();
    public BSTIterator(TreeNode root) {
        
        // getInorder(root, inorder);

        pushAll(root);

    }
    
    public int next() {
        
        // int val =  inorder.get(temp);
        // temp++;
        // return val;
        TreeNode tmpNode = stack.pop();
        pushAll(tmpNode.right);
        return tmpNode.val;
    }
    
    public boolean hasNext() {
        // return temp < inorder.size();
         return !stack.isEmpty();
       
    }

    //
    private void pushAll(TreeNode node){
        for(; node != null; node = node.left) stack.push(node);
    }

    //
    // public List<Integer> getInorder(TreeNode root, List<Integer> list){
    //     //
    //     if(root == null){
    //         return list;
    //     }
    //     getInorder(root.left,list);
    //     list.add(root.val);
    //     getInorder(root.right,list);

    //     return list;
    // }
}

/**
 * Your BSTIterator object will be instantiated and called as such:
 * BSTIterator obj = new BSTIterator(root);
 * int param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */