class Solution {
    public String largestMultipleOfThree(int[] digits) {
        int sum=0;
        int n=digits.length;
        for(int x:digits)sum+=x;
        if(sum%3==0)
        {
            Arrays.sort(digits);
            return convert(digits);
        }
        if(sum%3==1)
        {
            Arrays.sort(digits);
            for(int i=0;i<n;i++)
            {
                if(digits[i]%3==1)
                {
                    digits[i]=-1;
                    Arrays.sort(digits);
                    return convert(digits);
                }
            }
            int c=0;
              for(int i=0;i<n;i++)
            {
                if(digits[i]%3==2)
                {
                    digits[i]=-1;
                    c++;
                }
                  if(c==2)
                  {
                      Arrays.sort(digits);
                    return convert(digits);
                  }
            }
            
            return "";
        }
              if(sum%3==2)
        {
            Arrays.sort(digits);
            for(int i=0;i<n;i++)
            {
                if(digits[i]%3==2)
                {
                    digits[i]=-1;
                    Arrays.sort(digits);
                    return convert(digits);
                }
            }
                     int c=0;
              for(int i=0;i<n;i++)
            {
                if(digits[i]%3==1)
                {
                    digits[i]=-1;
                    c++;
                }
                  if(c==2)
                  {
                      Arrays.sort(digits);
                    return convert(digits);
                  }
            }
            return "";
        }
        
        return "";
    }
    public String convert(int arr[])
    {
        int n=arr.length;
       // if(n==0)return "";
        StringBuilder  ans=new StringBuilder();
        for(int i=arr.length-1;i>=0;i--)
            
        {
            int x=arr[i];
            if(x<0)break;
            ans.append(x);
        }
        if(ans.length()==0)return "";
        if(ans.charAt(0)=='0')return "0";
        return ans.toString();
    }
}