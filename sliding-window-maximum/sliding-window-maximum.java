class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        int n=nums.length;
        int nextGreater[]=new int[n];
        Stack<Integer>st=new Stack<>();
        Arrays.fill(nextGreater,n);
        int i=0;
        while(i<n)
        {
            
            while(st.size()>0 && nums[st.peek()]<nums[i])
            {
                nextGreater[st.pop()]=i;
            }
                st.push(i++);
        }
        int ans[]=new int[n-k+1];
        for( i=0;i<=n-k;i++)
        {
            int j=i;
            while(nextGreater[j]<i+k)
            {
                j=nextGreater[j];
            }
            
            ans[i]=nums[j];
        }
        return ans;
    }
}