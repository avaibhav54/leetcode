class Solution {
    public boolean canReach(int[] arr, int start) {
        return help(arr,start,new boolean[arr.length]);
    }
    
    public static boolean help(int arr[],int st,boolean[] visited)
    {
        if(st<0 || st>=arr.length|| visited[st])return false;
        if(arr[st]==0)return true;
        visited[st]=true;
        boolean f1=help(arr,st+arr[st],visited);
        boolean f2=help(arr,st-arr[st],visited);
        return f1 | f2;
    }
}