# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def subtreeWithAllDeepest(self, root: Optional[TreeNode]) -> Optional[TreeNode]:
        return self.dfs(root, 0)[1]

    def dfs(self, node, depth):
        if not node:
            return depth, None

        left_depth, left_node = self.dfs(node.left, depth + 1)
        right_depth, right_node = self.dfs(node.right, depth + 1)

        if left_depth > right_depth:
            return left_depth, left_node
        elif right_depth > left_depth:
            return right_depth, right_node
        else:
            return left_depth, node