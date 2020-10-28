/*
 * @lc app=leetcode.cn id=221 lang=java
 *
 * [221] 最大正方形
 */

// @lc code=start
class Solution {
    public int maximalSquare(char[][] matrix) {
        // dp 定义：dp[i,j] 是 matrix[i-1,j-1]为右下角的正方形的最大边长。
        // 所以可以得出：if(matrix[i,j] == '1') dp[i,j] = min(dp[i-1,j], dp[i,j-1)，dp[i-1,j-1])
        // + 1;
        // 便于理解和方便计算，从 i = 1...n, j = 1...n，那么dp数组大小为new dp[height + 1][width + 1],
        // dp[i,j]为右下角的正方形最大边长
        if (matrix == null || matrix.length < 1 || matrix[0].length < 1) return 0;
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] dp = new int[m + 1][n + 1];
        int maxSide = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == '1') {
                    dp[i + 1][j + 1] = Math.min(Math.min(dp[i][j + 1], dp[i + 1][j]), dp[i][j]) + 1;
                    maxSide = Math.max(maxSide, dp[i + 1][j + 1]);
                }
            }
        }
        return maxSide * maxSide;
    }
}
// @lc code=end
