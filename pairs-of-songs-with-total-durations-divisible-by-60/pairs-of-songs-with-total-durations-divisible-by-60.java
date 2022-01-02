class Solution{
    public int numPairsDivisibleBy60(int[] time) {
        int[] mod = new int[60];
        for(int t : time) mod[t%60]++; //count the number of differnt modulation cases of divided by 60. 
        int res = 0;
        for(int i = 0; i <= 30; i++){//sum to 30 to avoid double counting
            if(i == 0 || i == 30) res += (mod[i])*(mod[i]-1)/2; //special case: modulation is 0 or 30. 
            else res += mod[i] * mod[60-i]; //general case
        }
        return res;
    }
}