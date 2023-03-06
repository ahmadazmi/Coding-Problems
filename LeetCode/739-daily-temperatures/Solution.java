import java.util.*;

class Solution {
    /*
     * Another method of doing this problem would be to use our answer[] array to replace the stack.
     * Suppose:
     *      - temperatures:     [46,45,30,31,48]
     *      - answer:           [* ,* ,* ,* , 0], where * represents unknown value.
     * If we go from right to left of temperatures array (while skipping first element), we'll encounter 31.
     * 31 is less than 48, so answer[3] = 1.
     * Next comes 30, 30 is less than 31, so answer[2] = 1
     * However, 45 is greater than 30, so we jump to answer[x], where x = (index of 30 + answer[2]) = 2+1 = 3
     * We notice that 45 is still greater than temperatures[x] = 31, so we jump again to answer[x], where x = (index of 31 + answer[3]) = 3+1 = 4
     * temperatures[x] = 48 is finally greater than 45, so answer[1] = x - index of 45 = 4 - 1 = 3.
     * 
     * Now our current answer looks like so: [* , 3, 1, 1, 0]
     * We're are temperature 46 now, and 46 > 45 so we jump to answer[x], where x = (index of 46 + answer[1]) = 1 + 3 = 4
     * We see that temperatures[x] > 46, so then answer[0] = x - index of 46 = 4 - 0 = 4
     */
    
    class Element {
        int temp;
        int idx;
        public Element(int temp, int idx) {this.temp = temp; this.idx = idx;}
    }

    public int[] dailyTemperatures(int[] temperatures) {
        Stack<Element> s = new Stack<>();
        int[] answer = new int[temperatures.length];
        s.push(new Element(temperatures[temperatures.length-1], temperatures.length-1));
        for (int i = temperatures.length-2; i >= 0; i--) {
            while (!s.isEmpty() && s.peek().temp <= temperatures[i]) s.pop();
            if (!s.isEmpty()) answer[i] = s.peek().idx - i;
            s.push(new Element(temperatures[i], i));
        }
        return answer;
    }
}