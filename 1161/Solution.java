import java.util.Queue;

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
    public int maxLevelSum(TreeNode root) {
        int maxSum = Integer.MIN_VALUE;
        int currentLevel = 0;
        int resultLevel = 0;
        Queue<TreeNode> queue = new java.util.LinkedList<>();

        queue.offer(root);
        while (!queue.isEmpty()) {
            int levelSum = 0;
            int levelSize = queue.size();
            for (int i = 0; i < levelSize; i++) {
                TreeNode node = queue.poll();
                levelSum += node.val;
                if (node.left != null) {
                    queue.offer(node.left);
                }
                if (node.right != null) {
                    queue.offer(node.right);
                }
            }
            currentLevel++;
            if (levelSum > maxSum) {
                maxSum = levelSum;
                resultLevel = currentLevel;
            }
        }
        return resultLevel;
    }
}