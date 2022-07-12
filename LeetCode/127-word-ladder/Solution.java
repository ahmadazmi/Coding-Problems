import java.util.*;

class Solution {
    /*
        Idea: Imagine traversing a tree graph. The beginWord will be the root node, the children
        of this root node will be words that are one letter away from it. The children of
        those words will also be words that are one letter away from it.
        This can be accomplished by imagining a breadth first search using a Queue. The Queue
        will initially contain the beginWord and then by using a while loop, dequeue beginWord and
        search for all words that are one letter away from it, add those words in the Queue.
    */
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        // Check if endWord is in wordList
        if(!wordList.contains(endWord)) return 0;
        // depth = 1 because at least one conversion is needed
        int depth = 1;
        LinkedList<String> bfs = new LinkedList<>();
        bfs.add(beginWord);
        while (!bfs.isEmpty()) {
            // Width denotes the current number of words in this level of bfs
            int width = bfs.size();
            for (int i = 0; i < width; i++) {
                String word = bfs.poll();
                int j = 0;
                while (j < wordList.size()) {
                    if (hasOneCharDifference(word, wordList.get(j))) {
                        if (wordList.get(j).equals(endWord)) return depth+1;
                        bfs.add(wordList.get(j));
                        wordList.remove(j);
                    }
                    else j++;
                }
            }
            depth++;
        }
        return 0;
    }
    
    private boolean hasOneCharDifference(String s1, String s2) {
        int difference = 0, i = 0;
        while (i < s1.length() && difference <= 1)
            if (s1.charAt(i) != s2.charAt(i++)) difference++;
        return difference <= 1 ? true : false;
    }
}