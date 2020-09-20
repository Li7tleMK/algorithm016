/*
 * @lc app=leetcode.cn id=242 lang=java
 *
 * [242] 有效的字母异位词
 */

// @lc code=start
class Solution {
    /**
     * s1:对s和t排序，再比较 s2:设置 1 个 int 数组 charAtIndex, 26 长度，对 s 和 t 中的每个 char 进行遍历
     * 取 s 和 t 中的每个字符 - 'a' 作为下标放入 charAtIndex，最后数组charAtIndex中每个元素为 0，即为 true。
     */
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] charAtIndex = new int[26];
        for (int i = 0; i < s.length(); i++) {
            charAtIndex[s.charAt(i) - 'a']++;
            charAtIndex[t.charAt(i) - 'a']--;
        }
        for (int n : charAtIndex) {
            if (n != 0) {
                return false;
            }
        }
        return true;
    }
}
// @lc code=end
