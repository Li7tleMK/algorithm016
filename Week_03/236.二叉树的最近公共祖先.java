/*
 * @lc app=leetcode.cn id=236 lang=java
 *
 * [236] 二叉树的最近公共祖先
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // 终止条件
        if (root == null || root == p || root == q)
            return root;
        
        // 递归处理
        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // 当 left 和 right 同时为空，说明某个节点的左右子树不存在 p 和 q，返回null
        if (left == null && right == null)
            return null;
        // 当 left 为空，right 不为空，p 和 q 不存在与 left中，直接返回 right
        if (left == null)
            return right;

        // 当 right left 不为空，p 和 q 不存在与 right 中，直接返回 left
        if (right == null)
            return left;
        // 当 left 和 right 都不为空，说明 p 和 q 存在于 root 的左右子树中，返回root
        return root;
    }
}
// @lc code=end