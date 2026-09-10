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

    public int averageOfSubtree(TreeNode root) {

        if (root == null) {
            return 0;
        }

        int count = 0;

        if (root.val == getSum(root) / getCount(root)) {
            count++;
        }

        count += averageOfSubtree(root.left);
        count += averageOfSubtree(root.right);

        return count;
    }

    private int getSum(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return root.val + getSum(root.left) + getSum(root.right);
    }

    private int getCount(TreeNode root) {

        if (root == null) {
            return 0;
        }

        return 1 + getCount(root.left) + getCount(root.right);
    }
}