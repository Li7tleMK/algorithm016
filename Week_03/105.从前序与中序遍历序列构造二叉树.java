/*
 * @lc app=leetcode.cn id=105 lang=java
 *
 * [105] 从前序与中序遍历序列构造二叉树
 */

// @lc code=start
/**
 * Definition for a binary tree node. public class TreeNode { int val; TreeNode
 * left; TreeNode right; TreeNode(int x) { val = x; } }
 */
class Solution {
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < inorder.length; i++) {
            map.put(inorder[i], i);
        }
        return buildTreeHelper(preorder, 0, preorder.length, inorder, 0, inorder.length, map);
    }

    private TreeNode buildTreeHelper(int[] preorder, int p_start, int p_end, int[] inorder, int i_start, int i_end,
            Map<Integer, Integer> map) {
        if (p_start == p_end) {
            return null;
        }

        // TreeNode root = new TreeNode(preorder[p_start]);
        // int in_root_index = 0;
        // for (int i = i_start; i < i_end; i++) {
        //     if (inorder[i] == root.val) {
        //         in_root_index = i;
        //         break;
        //     }
        // }
        TreeNode root = new TreeNode(preorder[p_start]);
        int in_root_index = map.get(root.val);
        int leftNum = in_root_index - i_start;

        root.left = buildTreeHelper(preorder, p_start + 1, p_start + leftNum + 1, inorder, i_start, in_root_index, map);
        root.right = buildTreeHelper(preorder, p_start + leftNum + 1, p_end, inorder, in_root_index + 1, i_end, map);
        return root;
    }
}
// @lc code=end
