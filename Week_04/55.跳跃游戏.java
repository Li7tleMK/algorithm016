/*
 * @lc app=leetcode.cn id=55 lang=java
 *
 * [55] 跳跃游戏
 */

// @lc code=start
class Solution {
    public boolean canJump(int[] nums) {
        // 一步步跳，currentMax 表示当前能跳到的最大距离
        int currentMax = 0;
        for (int i = 0; i < nums.length; i++) {
            // 如果当前 i 比 一步步跳，currentMax 还要大，说明无法继续跳下去了
            if (i > currentMax) {
                return false;
            }
            currentMax = Math.max(currentMax, i + nums[i]);
        }
        return true;
    }
}
// @lc code=end
