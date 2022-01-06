class Solution {
    public boolean carPooling(int[][] trips, int capacity) {
    int max=0;
        for(int trip[]:trips)
        {
            max=Math.max(max,trip[2]);
        }
        int arr[]=new int[1001];
        for(int trip[]:trips)
        {
            arr[trip[1]]+=trip[0];
            arr[trip[2]]-=trip[0];
        }
        int x=0;
        for(int i=0;i<max;i++)
        {
            if(x>capacity)return false;
           x+=arr[i]; 
        }
        return true;
    }
}