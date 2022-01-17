class Solution {
    public int longestArithSeqLength(int[] nums) {
        int n=nums.length;
        int ans=0;
        HashMap<Integer,Integer>[]  dp=new HashMap[n];
        for(int i=0;i<n;i++)dp[i]=new HashMap();
        for(int i=0;i<n;i++)
        {
            HashMap<Integer,Integer>map1=dp[i];
            for(int j=0;j<i;j++)
            {
                int cd=nums[i]-nums[j];
                
            HashMap<Integer,Integer>map2=dp[j];
                int len=1;
                if(map2.containsKey(cd))
                {
                    len+=map2.get(cd);
                    
                }
                map1.put(cd,len);
                ans=Math.max(ans,len);
            }
        }
        return ans+1;
    }
}