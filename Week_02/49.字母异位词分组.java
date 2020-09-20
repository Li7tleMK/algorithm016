/*
 * @lc app=leetcode.cn id=49 lang=java
 *
 * [49] 字母异位词分组
 */

// @lc code=start
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashMap = new HashMap<>();
        for (String str : strs) {
            char[] c = str.toCharArray();
            Arrays.sort(c);
            String key = String.valueOf(c);
            if (hashMap.containsKey(key)) {
                hashMap.get(key).add(str);
            } else {
                List<String> list = new ArrayList<>();
                list.add(str);
                hashMap.put(key, list);
            }
        }
        return new ArrayList<>(hashMap.values());
    }
}
// @lc code=end

