class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        int n=nums.size();
      int ans[]={-100000,100000};
        PriorityQueue<Pair>pq=new PriorityQueue<>((a,b)->a.elem-b.elem);
        int len=200000;
        int max=Integer.MIN_VALUE;
        for(int i=0;i<n;i++)
        {
            int ele=nums.get(i).get(0);
            max=Math.max(max,ele);
            pq.add(new Pair(ele,i,0));
        }
        while(true)
        {
            Pair rem=pq.remove();
            if(ans[1]-ans[0]>max-rem.elem)
            {
                ans[0]=rem.elem;
                ans[1]=max;
            }
            List<Integer>cl=nums.get(rem.i);
            if(rem.j==cl.size()-1)break;
            int elem=cl.get(rem.j+1);
            pq.add(new Pair(elem,rem.i,rem.j+1));
            max=Math.max(max,elem);
        }
        
        return ans;
    }
    public static class Pair
    {
        int elem;
        int i;
        int j;
        Pair(int elem,int i,int j)
        {
            this.elem=elem;
            this.i=i;
            this.j=j;
        }
    }
}