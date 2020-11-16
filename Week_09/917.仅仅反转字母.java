/*
 * @lc app=leetcode.cn id=917 lang=java
 *
 * [917] 仅仅反转字母
 */

// @lc code=start
class Solution {
    public String reverseOnlyLetters(String S) {
        char[] letters = S.toCharArray();
        char[] resLetters = new char[letters.length];
        for (int i = letters.length - 1, j = 0; i >= 0; i--) {
            if (isLetter(letters[i])) {
                while (!isLetter(letters[j])) j++;
                resLetters[j++] = letters[i];
            } else {
                resLetters[i] = letters[i];
            }
        }
        return new String(resLetters);
    }

    private boolean isLetter(char c) {
        int i = c;
        return (i >= 65 && i <= 90) || (i >= 97 && i <= 122);
    }
}
// @lc code=end
