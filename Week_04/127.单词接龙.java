import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=127 lang=java
 *
 * [127] 单词接龙
 */

// @lc code=start
class Solution {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        Set<String> wordSet = new HashSet<>(wordList);

        if (wordSet.size() == 0 || !wordSet.contains(endWord)) {
            return 0;
        }

        wordSet.remove(beginWord);

        // 1. 建立一个队列，用于遍历所有 wordList
        Queue<String> queue = new LinkedList<>();
        queue.offer(beginWord);
        // 2. 建立一个放过的 visited，用于保存单词是否被使用过
        Set<String> visited = new HashSet<>();
        visited.add(beginWord);

        // 开始默认为1
        int step = 1;
        // 3. BFS 搜索是否能用 beginWord 搜索到 endWord。并且每搜一次 +1
        while (!queue.isEmpty()) {
            int currentSize = queue.size();
            for (int i = 0; i < currentSize; i++) {
                String currentWord = queue.poll();
                if (checkEveryWord(currentWord, endWord, queue, visited, wordSet)) {
                    return step + 1;
                }
            }
            step++;
        }
        return 0;
    }

    public boolean checkEveryWord(String currentWord, String endWord, Queue<String> queue, Set<String> visited,
            Set<String> wordSet) {
        char[] charArray = currentWord.toCharArray();
        for (int i = 0; i < endWord.length(); i++) {
            // 保存下 currentWord 的索引 i 的字母，因为 a - z 循环查找结束需要还原回去，对 i + 1 的字母做处理
            char originLetter = charArray[i];

            for (k = 'a'; k <= 'z'; k++) {
                if (k == originLetter) {
                    continue;
                }

                charArray[i] = k;

                // 基于currentWord 每改变一个字母就去比较
                String nextWord = String.valueOf(charArray);
                if (wordSet.contains(nextWord)) {
                    // 如果跟 endWord 相同，直接结束
                    if (nextWord.equals(endWord)) {
                        return true;
                    }
                    if (!visited.contains(nextWord)) {
                        visited.add(nextWord);
                        queue.offer(nextWord);
                    }
                }
            }

            charArray[i] = originLetter;
        }
        return false;
    }
}
// @lc code=end
