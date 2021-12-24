class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals,(a,b)->a[0]-b[0]);
        
        ArrayList<int[]> ans=new ArrayList<int[]>();
        int n=intervals.length;
        int prev[]=intervals[0];
        for(int i=1;i<n;i++)
        {
            int current[]=intervals[i];
            if(prev[1]<current[0])
            {
                ans.add(prev);
                prev=current;
            }
            else
            {
                prev[1]=Math.max(prev[1],current[1]);
            }
        }
        ans.add(prev);
        int anss[][]=new int[ans.size()][2];
        int i=0;
        for(int as[]:ans)
        {
            anss[i++]=as;
        }
        return anss;
        
    }
}