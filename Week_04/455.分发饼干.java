import java.util.Arrays;

/*
 * @lc app=leetcode.cn id=455 lang=java
 *
 * [455] 分发饼干
 */

// @lc code=start
class Solution {
    public int findContentChildren(int[] g, int[] s) {
        int childCount = 0;
        int curChildIndex = g.length - 1;
        Arrays.sort(g);
        Arrays.sort(s);
        // 2个数组均从末尾开始贪心，外层循环饼干，
        // 内层循环找能满足的最大胃口孩子 curChildIndex 并记录满足的孩子数量 childCount
        for (int i = s.length - 1; i >= 0; i--) {
            for (int j = curChildIndex; j >= 0; j--) {
                if (s[i] >= g[j]) {
                    childCount++;
                    curChildIndex = j - 1;
                    break;
                }
            }
        }
        return childCount;
    }
}
// @lc code=end
