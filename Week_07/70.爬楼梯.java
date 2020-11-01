/*
 * @lc app=leetcode.cn id=70 lang=java
 *
 * [70] 爬楼梯
 */

// @lc code=start
class Solution {
    public int climbStairs(int n) {
        // int[] memo = new int[n + 1];
        // return helper(memo, n);
        if (n <= 1) return n;
        int[] dp = new int[n];
        dp[0] = 1;
        dp[1] = 2;
        for (int i = 2; i < dp.length; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n - 1];
    }

    // public int helper(int[] memo, int n) {
    //     if (memo[n] > 0) {
    //         return memo[n];
    //     }
    //     if (n <= 2) {
    //         memo[n] = n;
    //     } else {
    //         memo[n] = helper(memo, n - 2) + helper(memo, n - 1);
    //     }
    //     return memo[n];
    // }
}
// @lc code=end
