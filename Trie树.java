// Trie树
class TrieNode {
    public char data;
    public TrieNode[] children = new TrieNode[26];
    public boolean isEndingChar = false;
    public TrieNode(char data) {
        this.data = data;
    }
}

public class Trie {
    private TrieNode root = new TrieNode('/');

    // insert a string
    public void insert(char[] text) {
        TrieNode p = root;
        for(int i=0; i<text.length; i++) {
            int index = text[i] - 'a';
            if(p.children[index] == null) {
                TrieNode newNode = TrieNode(text[i]);
                p.children[index] = newNode;
            }
            p = p.children[index];
        }
        p.isEndingChar = true;
    }

    // search a string
    public boolean find(char[] pattern) {
        TrieNode p = root;
        for(int i=0; i<pattern.length; i++) {
            int index = pattern[i] - 'a';
            if(p.children[index] == null) {
                return false;
            }
            p = p.children[index];
        }
        return p.isEndingChar;
    }
}
