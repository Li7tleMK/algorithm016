import java.util.ArrayList;
import java.util.List;

/*
 * @lc app=leetcode.cn id=46 lang=java
 *
 * [46] 全排列
 */

// @lc code=start
class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> res = new ArrayList<>();
        if (nums.length == 0) {
            return res;
        }

        dfs(0, nums, res, new ArrayList<Integer>(), new boolean[nums.length]);
        return res;
    }

    public void dfs(int index, int[] nums, List<List<Integer>> res, List<Integer> t, boolean[] used) {
        if (index == nums.length) {
            res.add(new ArrayList<Integer>(t));
            return;
        }

        for (int i = 0; i < nums.length; i++) {
            if (!used[i]) {
                t.add(nums[i]);
                used[i] = true;
                dfs(index + 1, nums, res, t, used);
                used[i] = false;
                t.remove(t.size() - 1);
            }
        }
    }

}
// @lc code=end
