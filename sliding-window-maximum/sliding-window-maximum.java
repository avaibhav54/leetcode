class Solution {
    //solutin using next greater element
//     public int[] maxSlidingWindow(int[] nums, int k) {
//         int n=nums.length;
//         int nextGreater[]=new int[n];
//         Stack<Integer>st=new Stack<>();
//         Arrays.fill(nextGreater,n);
//         int i=0;
//         while(i<n)
//         {
            
//             while(st.size()>0 && nums[st.peek()]<nums[i])
//             {
//                 nextGreater[st.pop()]=i;
//             }
//                 st.push(i++);
//         }
//         int ans[]=new int[n-k+1];
//         for( i=0;i<=n-k;i++)
//         {
//             int j=i;
//             while(nextGreater[j]<i+k)
//             {
//                 j=nextGreater[j];
//             }
            
//             ans[i]=nums[j];
//         }
//         return ans;
//     }
 public int[] maxSlidingWindow(int[] a, int k) {
        int n = a.length;
		int[] r = new int[n-k+1];
		int ri = 0;
		// store index
		Deque<Integer> q = new ArrayDeque<>();
		for (int i = 0; i < a.length; i++) {
			// remove numbers out of range k
			if (!q.isEmpty() && q.peek() == i - k) {
				q.poll();
			}
			// remove smaller numbers in k range as they are useless
			while (!q.isEmpty() && a[q.peekLast()] < a[i]) {
				q.pollLast();
			}
            
			q.offer(i);
			if (i >= k - 1) {
				r[ri++] = a[q.peek()];
			}
		}
		return r;
    }
        
}