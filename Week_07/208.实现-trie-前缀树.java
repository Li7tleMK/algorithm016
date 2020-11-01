/*
 * @lc app=leetcode.cn id=208 lang=java
 *
 * [208] 实现 Trie (前缀树)
 */

// @lc code=start
class Trie {

    private Trie[] links;

    private final int R = 26;

    private boolean isEnd;

    /** Initialize your data structure here. */
    public Trie() {
        links = new Trie[R];
    }

    public boolean containsKey(char ch) {
        return links[ch - 'a'] != null; 
    }

    public Trie get(char ch) {
        return links[ch - 'a'];
    }

    public void put(char ch, Trie trie) {
        links[ch - 'a'] = trie;
    }

    public void setEnd() {
        isEnd = true;
    }

    public boolean isEnd() {
        return isEnd;
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
        trieNode.setEnd();
    }

    private Trie searchPrefix(String word) {
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
        return searchPrefix(prefix) != null;
    }
}

/**
 * Your Trie object will be instantiated and called as such: Trie obj = new
 * Trie(); obj.insert(word); boolean param_2 = obj.search(word); boolean param_3
 * = obj.startsWith(prefix);
 */
// @lc code=end
