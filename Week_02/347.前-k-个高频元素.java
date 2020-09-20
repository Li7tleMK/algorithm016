/*
 * @lc app=leetcode.cn id=347 lang=java
 *
 * [347] 前 K 个高频元素
 */

// @lc code=start
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hashMap.containsKey(nums[i])) {
                Integer tmp = hashMap.get(nums[i]);
                hashMap.put(nums[i], ++tmp);
            } else {
                Integer tmp = 1;
                hashMap.put(nums[i], tmp);
            }
        }
        List<Map.Entry<Integer, Integer>> list = new ArrayList<>(hashMap.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue() - o1.getValue());
        return list.subList(0, k).stream().mapToInt(value -> value.getKey()).toArray();
    }
}
// @lc code=end
