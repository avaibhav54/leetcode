class Solution {
    public int minEatingSpeed(int[] piles, int h) {
          int n = piles.length; int mid = 0;
        int left = 1; int right = 0;
        
        for (int e : piles)
            right = Math.max(right, e);
        right /= h/n;
        right++;
        while (left < right) {
            mid = left + (right-left) / 2;
            int count = 0;
            for (int e : piles)
                count += e%mid == 0 ? e/mid : e/mid + 1;
            if (count <= h)
                right = mid;
            else
                left = mid+1;
        }
        return right;   
    }
}