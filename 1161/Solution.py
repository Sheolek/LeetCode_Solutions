# Definition for a binary tree node.
# class TreeNode:
#     def __init__(self, val=0, left=None, right=None):
#         self.val = val
#         self.left = left
#         self.right = right
class Solution:
    def maxLevelSum(self, root: Optional[TreeNode]) -> int:
        maxSum = root.val
        maxLevel = 1
        currentLevel = 1
        queue = [root]
        while queue:
            currentSum = 0
            nextQueue = []
            for node in queue:
                currentSum += node.val
                if node.left:
                    nextQueue.append(node.left)
                if node.right:
                    nextQueue.append(node.right)
            if currentSum > maxSum:
                maxSum = currentSum
                maxLevel = currentLevel
            queue = nextQueue
            currentLevel += 1
        return maxLevel