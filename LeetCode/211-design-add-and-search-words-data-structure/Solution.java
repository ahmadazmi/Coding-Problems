class WordDictionary {
    TreeNode head;

    private class TreeNode {
        boolean isAWord;
        TreeNode[] next;
        public TreeNode() {this.next = new TreeNode[26]; this.isAWord = false;}
    }

    public WordDictionary() {
        this.head = new TreeNode();
    }
    
    public void addWord(String word) {
        TreeNode node = this.head;
        for (int i = 0; i < word.length(); i++) {
            int k = (int)(word.charAt(i)-'a');
            if (node.next[k] == null) node.next[k] = new TreeNode();
            node = node.next[k];
        }
        node.isAWord = true;
    }
    
    public boolean search(String word) {
        return patternSearch(word, 0, this.head);
    }

    private boolean patternSearch(String word, int pos, TreeNode node) {
        if (node == null) return false;
        else if (word.length()-1 == pos) {
            if (word.charAt(pos) == '.') {
                for (int i = 0; i < 26; i++) if (node.next[i] != null && node.next[i].isAWord) return true;
                return false;
            }
            return node.next[word.charAt(pos)-'a'] != null && node.next[word.charAt(pos)-'a'].isAWord;
        }
        else if (word.charAt(pos) == '.') {
            for (int i = 0; i < 26; i++) if (patternSearch(word, pos+1, node.next[i])) return true;
            return false;
        }
        else return patternSearch(word, pos+1, node.next[word.charAt(pos)-'a']);
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */