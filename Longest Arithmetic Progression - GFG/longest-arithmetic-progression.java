// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());
        while (tc-- > 0) {
            int n = Integer.parseInt(br.readLine().trim());
            int a[] = new int[n];
            String inputLine[] = br.readLine().trim().split(" ");
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(inputLine[i]);
            }
            int ans = new Solution().lengthOfLongestAP(a, n);
            System.out.println(ans);
        }
    }
}

// } Driver Code Ends


//User function Template for Java

class Solution {
    int lengthOfLongestAP(int[] nums, int n) {
        // code here
           //int n=nums.length;
        int ans=1;
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
                else len++;
                map1.put(cd,len);
                ans=Math.max(ans,len);
            }
        }
        return ans;
    }
}
