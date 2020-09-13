/*
 * @lc app=leetcode.cn id=66 lang=java
 *
 * [66] 加一
 */

// @lc code=start
class Solution {
    public int[] plusOne(int[] digits) {
        // 思考过程：
        // 1.普通情况就是 + 1，比如：88 -> 89
        // 2.末尾是9，+1无进位，比如：89 -> 90
        // 3.末尾是9，+1有进位，比如：99 -> 100
        for (int i = digits.length - 1; i >= 0; i--) {
            digits[i]++;
            digits[i] %= 10;
            if (digits[i] != 0) {
                return digits;
            }
        }
        // 如果循环结束，还没有return，那么说明第3种情况
        digits = new int[digits.length + 1];
        digits[0] = 1;
        return digits;
    }
}
// @lc code=end
