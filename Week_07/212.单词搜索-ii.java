import java.util.HashSet;
import java.util.Set;

/*
 * @lc app=leetcode.cn id=212 lang=java
 *
 * [212] 单词搜索 II
 */

// @lc code=start
class Solution {
    public List<String> findWords(char[][] board, String[] words) {
        Trie trieRoot = new Trie();
        for (String word : words) {
            trieRoot.insert(word);
        }
        int m = board.length, n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        Set<String> results = new HashSet<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                find(board, m, n, i, j, visited, results, trieRoot);
            }
        }
        return new LinkedList<>(results);

    }

    private void find(char[][] board, int m, int n, int i, int j, boolean[][] visited, Set<String> results,
            Trie trieCurrent) {
        if (i < 0 || j < 0 || i >= m || j >= n || visited[i][j]) {
            return;
        }

        trieCurrent = trieCurrent.searchPrefix(board[i][j] + "");
        visited[i][j] = true;
        if (trieCurrent == null) {
            visited[i][j] = false;
            return;
        }

        if (trieCurrent.isEnd()) {
            results.add(trieCurrent.getVal());
        }

        find(board, m, n, i + 1, j, visited, results, trieCurrent);
        find(board, m, n, i, j + 1, visited, results, trieCurrent);
        find(board, m, n, i, j - 1, visited, results, trieCurrent);
        find(board, m, n, i - 1, j, visited, results, trieCurrent);

        visited[i][j] = false;
    }
}

class Trie {
    private Trie[] links;
    private boolean isEnd;
    private String val;

    /** Initialize your data structure here. */
    public Trie() {
        links = new Trie[26];
    }

    private boolean containsKey(char ch) {
        return links[ch - 'a'] != null;
    }

    private Trie get(char ch) {
        return links[ch - 'a'];
    }

    private void put(char ch, Trie trie) {
        links[ch - 'a'] = trie;
    }

    public boolean isEnd() {
        return isEnd;
    }

    public void setEnd() {
        isEnd = true;
    }

    public String getVal() {
        return val;
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Trie trieNode = this;
        for (char currentChar : word.toCharArray()) {
            if (!trieNode.containsKey(currentChar)) {
                trieNode.put(currentChar, new Trie());
            }
            trieNode = trieNode.get(currentChar);
        }
        trieNode.val = word;
        trieNode.setEnd();
    }

    public Trie searchPrefix(String word) {
        Trie trieNode = this;
        for (char currentChar : word.toCharArray()) {
            if (trieNode.containsKey(currentChar)) {
                trieNode = trieNode.get(currentChar);
            } else {
                return null;
            }
        }
        return trieNode;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        Trie trieNode = searchPrefix(word);
        return trieNode != null && trieNode.isEnd();
    }

    /**
     * Returns if there is any word in the trie that starts with the given prefix.
     */
    public boolean startsWith(String prefix) {
        Trie trieNode = searchPrefix(prefix);
        return trieNode != null;
    }
}
// @lc code=end
