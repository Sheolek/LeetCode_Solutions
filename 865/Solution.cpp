/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    TreeNode* subtreeWithAllDeepest(TreeNode* root) {
        return helper(root).node;
    }

private:
    struct Result {
        TreeNode* node;
        int depth;

        Result(TreeNode* node, int depth) : node(node), depth(depth) {}
    };

    Result helper(TreeNode* node) {
        if (node == nullptr) {
            return Result(nullptr, 0);
        }

        Result left = helper(node->left);
        Result right = helper(node->right);

        if (left.depth > right.depth) {
            return Result(left.node, left.depth + 1);
        } else if (right.depth > left.depth) {
            return Result(right.node, right.depth + 1);
        } else {
            return Result(node, left.depth + 1);
        }
    }
};