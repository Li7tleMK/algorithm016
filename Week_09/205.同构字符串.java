/*
 * @lc app=leetcode.cn id=205 lang=java
 *
 * [205] 同构字符串
 */

// @lc code=start
class Solution {
    public boolean isIsomorphic(String s, String t) {
        /**
         * s 存在 [0..127], t 存在 [128, 255]
         * 每次遍历放入对应下标，如果 ascII 码不同必然不是同构 return false
         */
        int[] m = new int[256];
        for (int i = s.length() - 1; i >= 0; i--) {
            if (m[s.charAt(i)] != m[t.charAt(i) + 128]) {
                return false;
            }
            m[s.charAt(i)] = m[t.charAt(i) + 128] = i;
        }
        return true;
    }
}
// @lc code=end
