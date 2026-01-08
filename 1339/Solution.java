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
    public int maxProduct(TreeNode root) {
        long MOD = 1_000_000_007;
        List<Long> subtreeSums = new ArrayList<>();
        long totalSum = computeSubtreeSums(root, subtreeSums);
        long maxProduct = 0;

        for (long subSum : subtreeSums) {
            long product = subSum * (totalSum - subSum);
            maxProduct = Math.max(maxProduct, product);
        }

        return (int)(maxProduct % MOD);
    }

    private long computeSubtreeSums(TreeNode node, List<Long> subtreeSums) {
        if (node == null) {
            return 0;
        }
        long leftSum = computeSubtreeSums(node.left, subtreeSums);
        long rightSum = computeSubtreeSums(node.right, subtreeSums);
        long currentSum = leftSum + rightSum + node.val;

        subtreeSums.add(currentSum);
        return currentSum;
    }
}