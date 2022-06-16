import java.util.*;

class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        int[] warmerDay = new int[temperatures.length];
        Stack<Integer> temperaturesStack = new Stack<>();
        Stack<Map.Entry<Integer, Integer>> nextTemperature = new Stack<>();
        for (int temp : temperatures) temperaturesStack.push(temp);
        int i = temperatures.length-1;
        while (!temperaturesStack.isEmpty()) {
            if (!nextTemperature.isEmpty()) {
                while (!nextTemperature.isEmpty() && nextTemperature.peek().getValue() <= temperaturesStack.peek())
                    nextTemperature.pop();
                if (!nextTemperature.isEmpty())
                    warmerDay[i] = nextTemperature.peek().getKey()-i;
            }
            nextTemperature.push(Map.entry(i, temperaturesStack.pop()));
            i--;
        }
        return warmerDay;
    }
}