public int nthUglyNumber(int n) {
    /**
     * 基本思路：
     * 1.设置一个从小到大的N个丑数的数组,叫dp
     * 2.1是丑数放入dp[0]
     * 3.那么以后的丑数肯定是排前面的丑数乘2、或乘3、或乘5(2、3、5暂且叫3个因子)，也有可能同时乘2个或3个因子。
     * 4.设置3个指针,d2指向的数字永远乘2，d3指向的数字永远乘3，d5指向的数字永远乘5
     * 5.我们从2*dp[d2], 3*dp[d3], 5*dp[d5]选取最小的一个数字，作为新的丑数，这里dp[0]=1,第2个丑数是2*dp[d2] = 2，所以要d2++
     * 6.重复第5步
     */
    if (n <= 0) return -1;
    int[] dp = new int[n];
    dp[0] = 1;
    int d2 = 0, d3 = 0, d5 = 0;
    for (int i = 1; i < n; i++) {
        dp[i] = Math.min(dp[d2] * 2, Math.min(dp[d3] * 3, dp[d5] * 5));
        if (dp[d2] * 2 == dp[i])
            d2++;
        if (dp[d3] * 3 == dp[i])
            d3++;
        if (dp[d5] * 5 == dp[i])
            d5++;
    }
    return dp[n - 1];
}