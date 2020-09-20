import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

import com.sun.org.apache.xalan.internal.xsltc.runtime.Node;

/*
 * @lc app=leetcode.cn id=589 lang=java
 *
 * [589] N叉树的前序遍历
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
    public List<Integer> preorder(Node root) {
        List<Integer> output = new LinkedList<>();
        Stack<Node> stack = new Stack<>();
        if (root == null) {
            return output;
        }
        stack.push(root);
        while(!stack.isEmpty()){
            Node node = stack.pop();
            output.add(node.val);
            Collections.reverse(node.children);
            for (Node child : node.children) {
                stack.push(child);
            }
        }
        return output;
    }
}
// @lc code=end
