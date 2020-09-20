import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

import com.sun.corba.se.impl.orbutil.graph.Node;

/*
 * @lc app=leetcode.cn id=429 lang=java
 *
 * [429] N叉树的层序遍历
 */

// @lc code=start
/*
// Definition for a Node.
class Node {
    public int val;
    public List<Node> children;

    public Node() {}

    public Node(int _val) {
        val = _val;
    }

    public Node(int _val, List<Node> _children) {
        val = _val;
        children = _children;
    }
};
*/

class Solution {
    public List<List<Integer>> levelOrder(Node root) {
        if (root == null) {
            return new ArrayList<>();
        }
        List<List<Integer>> total = new ArrayList<>();
        List<Node> preNodeLayer = Arrays.asList(root);
        while (!preNodeLayer.isEmpty()) {
            List<Node> curNodeLayer = new ArrayList<>();
            List<Integer> levelRes = new ArrayList<>();
            for (Node node : preNodeLayer) {
                levelRes.add(node.val);
                curNodeLayer.addAll(node.children);
            }
            total.add(levelRes);
            preNodeLayer = curNodeLayer;
        }
        return total;
    }
}
// @lc code=end

