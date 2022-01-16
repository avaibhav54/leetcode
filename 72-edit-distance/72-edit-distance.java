class Solution {
    public int minDistance(String word1, String word2) {
        int n1=word1.length();
        int n2=word2.length();
        int dp[][]=new int[n1+2][n2+2];
        for(int i=0;i<=n1;i++)
        {
            for(int j=0;j<=n2;j++)
            {
                if(i==0)
                {
                    dp[i][j]=j;
                }
                else if(j==0)
                {
                    dp[i][j]=i;
                }
                else
                {
                    
                char ch=word1.charAt(i-1);
                char ch2=word2.charAt(j-1);
                    int c=Math.min(dp[i-1][j],Math.min(dp[i][j-1],dp[i-1][j-1]));
                   if(ch==ch2)dp[i][j]=dp[i-1][j-1];
                    else dp[i][j]=1+c;
                    
                }
            }
        }
        
        
        return dp[n1][n2];
    }
}