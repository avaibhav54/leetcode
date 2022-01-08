class KthLargest {

    final PriorityQueue<Integer> pq;
    final int k;

    public KthLargest(int k, int[] nums) {
        
        this.k = k;
        
        pq = new PriorityQueue<>();
        
        int len = Math.min(nums.length, k);
        for (int i = 0; i < len; i++) {
            
            pq.add(nums[i]);
        }
        
        for (int i = len; i < nums.length; i++) {
            
            if (nums[i] > pq.peek()) {
                    
                pq.poll();
                pq.add(nums[i]);
            }
        }
    }
    
    public int add(int val) {
        
        if (pq.size() < k) {
            
             pq.add(val);
        } else if (val > pq.peek()) {
            
            pq.poll();
            pq.add(val);
        }
        
        return pq.peek();
    }
}