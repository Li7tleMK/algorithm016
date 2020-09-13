/*
 * @lc app=leetcode.cn id=26 lang=java
 *
 * [26] 删除排序数组中的重复项
 */

// @lc code=start
class Solution {
    public int removeDuplicates(int[] nums) {
        // 设置一个指针，指向未出现重复的元素的下标。一开始指向0
        int noRepeatIndex = 0;
        if (nums == null)
            return 0;
        // 因为数组为 0 或 1 没必要做重复性校验
        if (nums.length <= 1)
            return nums.length;
        for (int i = 1; i < nums.length; i++) {
            // 题目中提示是有序数组，所以可以和前一个元素比较是否不同
            if (nums[i] != nums[i - 1]) {
                nums[noRepeatIndex + 1] = nums[i];
                noRepeatIndex++;
            }
        }
        // 因为指针指向的是数组的下标，返回需要长度，所以 + 1
        return noRepeatIndex + 1;
    }
}
// @lc code=end
