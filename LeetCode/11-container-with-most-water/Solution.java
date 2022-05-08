class Solution {
    public int maxArea(int[] height) {
        // Left and right pointers to probe the heights
        int lp = 0, rp = height.length-1;
        // Variable holding maximum area
        int max_area = 0;

        while (lp < rp) {
            int current_area = (rp-lp)*Math.min(height[lp], height[rp]);
            if (current_area > max_area) max_area = current_area;
            if (height[lp] < height[rp]) lp++;
            else rp--;
        }
        return max_area;
    }
}
