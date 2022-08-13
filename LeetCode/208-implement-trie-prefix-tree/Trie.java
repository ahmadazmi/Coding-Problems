class Trie {
    class Tree {
        Tree[] child;
        boolean exists;
        Tree(int size) {
            this.child = new Tree[size];
        }
    }

    Tree trie;
    
    public Trie() {
        this.trie = new Tree(26);
    }
    
    public void insert(String word) {
        Tree node = trie;
        for (int i = 0; i < word.length(); i++) {
            if (node.child[word.charAt(i)-'a'] == null)
                node.child[word.charAt(i)-'a'] = new Tree(26);
            node = node.child[word.charAt(i)-'a'];
        }
        node.exists = true;
    }
    
    public boolean search(String word) {
        Tree node = trie;
        for (int i = 0; i < word.length(); i++) {
            if (node.child[word.charAt(i)-'a'] == null) return false;
            node = node.child[word.charAt(i)-'a'];
        }
        return node.exists;
    }
    
    public boolean startsWith(String prefix) {
        Tree node = trie;
        for (int i = 0; i < prefix.length(); i++) {
            if (node.child[prefix.charAt(i)-'a'] == null) return false;
            node = node.child[prefix.charAt(i)-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */