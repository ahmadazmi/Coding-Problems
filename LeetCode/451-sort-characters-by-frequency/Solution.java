import java.util.*;

class Solution {
    public String frequencySort(String s) {
        HashMap<Character, Integer> frequencyMap = new HashMap<>();
        for (char letter : s.toCharArray())
            frequencyMap.merge(letter, 1, (a, b) -> a+b);
        
        PriorityQueue<Map.Entry<Character, Integer>> frequencyHeap = new PriorityQueue<>((a, b) -> (b.getValue() - a.getValue()));
        frequencyHeap.addAll(frequencyMap.entrySet());
        
        StringBuilder sortedString = new StringBuilder();
        while (!frequencyHeap.isEmpty()) {
            Map.Entry<Character, Integer> charFrequency = frequencyHeap.poll();
            for (int i = 0; i < (int) charFrequency.getValue(); i++) sortedString.append(charFrequency.getKey());
        }
        return sortedString.toString();
    }
}