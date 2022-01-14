class Solution {
   public static int sum(int n){
    return (n * (n+1))/2;
}

public int reachNumber(int target) {
    target = Math.abs(target);
    int n = (int)Math.floor((Math.sqrt(1+8l*target)-1)/2);
    if(sum(n) == target){
        return n;
    }else{
        n++;
        int diff = sum(n) - target;
        if(diff % 2 == 0){
            return n;
        }else{
            n++;
            diff = sum(n) - target;
            if(diff % 2 == 0){
                return n;
            }else{
                n++;
                return n;
            }
        }
    }
}
}