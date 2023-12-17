package org.example.backtracking;

public class PrefixTree {
    static class TrieNode {
        TrieNode[] children = new TrieNode[26];
        boolean isWord;
    }

    static class Trie {
        TrieNode root = new TrieNode();

        public void insert(String word) {
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    curr.children[index] = new TrieNode();
                }
                curr = curr.children[index];
            }
            curr.isWord = true;
        }

        public boolean search(String word) {
            return internalSearch(word, false);
        }

        public boolean startsWith(String prefix) {
            return  internalSearch(prefix, true);
        }
        private boolean internalSearch(String word, boolean isPrefix){
            TrieNode curr = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (curr.children[index] == null) {
                    return false;
                }
                curr = curr.children[index];
            }
            return isPrefix || curr.isWord;
        }
    }

    public static void main(String[] args) {
        Trie trie = new Trie();
        trie.insert("apple");
        System.out.println(trie.search("apple")); // returns true
        System.out.println(trie.search("app")); // returns false
        System.out.println(trie.startsWith("app")); // returns true
        trie.insert("app");
        System.out.println(trie.search("app")); // returns true
    }
}
