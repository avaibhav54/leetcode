class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        ArrayList graph[]=new ArrayList[numCourses];
        int cc[]=new int[numCourses];
        for(int i=0;i<numCourses;i++)
        {
            graph[i]=new ArrayList<>();
            
        }
        for(int pair[]:prerequisites)
        {
            cc[pair[1]]++;
            graph[pair[0]].add(pair[1]);
        }
        int count=0;
        Queue<Integer>q=new LinkedList<>();
        for(int i=0;i<numCourses;i++)
        {
            if(cc[i]==0)q.add(i);
        }
        while(q.size()>0)
        {
            int rem=q.remove();
            count++;
            ArrayList<Integer>get=graph[rem];
            for(int x:get)
            {
                cc[x]--;
                if(cc[x]==0)
                q.add(x);
            }
            
        }
       // System.out.println(count);
        return count>=numCourses;
    }
}