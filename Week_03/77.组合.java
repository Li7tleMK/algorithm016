import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=77 lang=java
 *
 * [77] 组合
 */

// @lc code=start
class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> res = new ArrayList<>();
        if (n == 0) {
            return res;
        }
        dfs(n, k, 1, new ArrayList<Integer>(), res);
        return res;
    }

    public void dfs(int n, int k, int index, List<Integer> t, List<List<Integer>> res) {
        if (t.size() + (n - index + 1) < k) {
            return;
        }
        if (t.size() == k) {
            res.add(new ArrayList<Integer>(t));
            return;
        }
        t.add(index);
        dfs(n, k, index + 1, t, res);
        t.remove(t.size() - 1);
        dfs(n, k, index + 1, t, res);
    }
}
// @lc code=end
