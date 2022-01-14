class Solution {
    public int myAtoi(String s) 
    {
        int i=0;//pointer to start of string
        int len=s.length();
        int sign=1;//sign of no.(+ve/-ve), default case: if nothing present consider +ve no.
        int res=0;
        
        if (s.length() == 0) return 0;
        //skip staring spaces
        while(i<len && s.charAt(i)==' ')
            i++;
        
        //determine sign of no.
        if(i<len && (s.charAt(i)=='-' || s.charAt(i)=='+') )
        {
            sign  = (s.charAt(i)=='-')?-1:1;
            i++;// next character
        }    
        
        //Continue while the character is a digit
        while(i<len && s.charAt(i)>='0' && s.charAt(i)<='9')
        {
            //Handling overflow cases
            if(res>Integer.MAX_VALUE/10 || (res==Integer.MAX_VALUE/10 && s.charAt(i)-'0'>7))
                return (sign==-1)?Integer.MIN_VALUE:Integer.MAX_VALUE;
            
            //Getting the no., +10 to shift the digits left
            res=10*res+(s.charAt(i)-'0');//s.charAt(i)-'0' is the digit(subtracting the ASCII values of char at i and 0)
            i++;
        }
        return sign*res;
    }
}