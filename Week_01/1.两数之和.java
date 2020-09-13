/*
 * @lc app=leetcode.cn id=1 lang=java
 *
 * [1] 两数之和
 */

// @lc code=start
class Solution {
    public int[] twoSum(int[] nums, int target) {
        // 解题关键点：找出个 2 个数（注意是 2 个，也就是1对，不存在第 2 对）
        // 思路：HashMap
        Map<Integer, Integer> hasMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hasMap.containsKey(target - nums[i])) {
                return new int[] { hasMap.get(target - nums[i]), i };
            }
            hasMap.put(nums[i], i);
        }
        return null;
    }
}
// @lc code=end
