/*
 * @lc app=leetcode.cn id=88 lang=java
 *
 * [88] 合并两个有序数组
 */

// @lc code=start
class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        // 方案1：nums2 并入 nums1 末尾，对 nums1 排序

        // 方案2：
        // 解题关键点：数组都有序，m + n 是组合后的数组大小
        // 2 个组数都从末尾开始遍历，那么只要挪动较大的数压入 nums1 末尾
        int i = m - 1, j = n - 1, k = m + n - 1;
        while (i >= 0 && j >= 0) {
            if (nums1[i] > nums2[j])
                nums1[k--] = nums1[i--];
            else
                nums1[k--] = nums2[j--];
        }
        // 最后检查 nums2 是否都挪到 nums1 中
        while (j >= 0) {
            nums1[k--] = nums2[j--];
        }
    }
}
// @lc code=end
