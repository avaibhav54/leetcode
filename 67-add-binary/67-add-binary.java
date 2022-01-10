class Solution {
    public String addBinary(String a, String b) {
        
        StringBuilder ans = new StringBuilder();
        int i = a.length()-1; int j = b.length()-1;
        int carry = 0; 
        
        while(i>=0 || j>=0){
            
            int aDigit = i < 0 ? 0 : a.charAt(i)-'0';
            int bDigit = j < 0 ? 0 : b.charAt(j)-'0';
            System.out.println(aDigit+carry+bDigit);
            int sum = (aDigit + bDigit + carry) ;
            carry = sum > 1 ? 1 : 0;
            ans.append((char) ((sum%2) + '0'));
            i--; j--;
        }
        
        if(carry==1) ans.append('1');
        return ans.reverse().toString();
    }
}