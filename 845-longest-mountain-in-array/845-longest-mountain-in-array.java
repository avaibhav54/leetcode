class Solution {
    public int longestMountain(int[] arr) {
       int n=arr.length;
        int lis_f[]=new int[n];
        int lis_b[]=new int[n];
        if(n<3)return 0;
        int ans=0;
        lis_f[0]=1;
        for(int i=1;i<n;i++)
        {
            if(arr[i]>arr[i-1])
            {
                lis_f[i]=1+lis_f[i-1];
            }
            else
            {
                lis_f[i]=1;
            }
        }
        lis_b[n-1]=1;
        for(int i=n-2;i>=0;i--)
        {
            if(arr[i]>arr[i+1])
            {
                lis_b[i]=1+lis_b[i+1];
            }
            else
            {
                lis_b[i]=1;
            }
        }
        for(int i=0;i<n;i++)
        {
            if(lis_f[i]!=1 && lis_b[i]!=1)
            ans=Math.max(ans,lis_f[i]+lis_b[i]);
        }
        return ans==0?0:ans-1;
    }
}