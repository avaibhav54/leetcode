class Solution {
//     public int maxDistToClosest(int[] arr) {
//         int left=0;
//         int n=arr.length;
//         for(int i=0;i<n;i++)
//         {
//             if(arr[i]==1)break;
//             left++;
//         }
//         int right=0;
//         for(int i=n-1;i>=0;i--)
//         {
//             if(arr[i]==1)break;
//             right++;
//         }
//          int prev=-1;
//         int till=0;
//        for(int i=left;i<n-right;i++)
//        {
//            if(arr[i]==1)prev=i;
//            till=Math.max(till,i-prev);
//        }
        
//         int ans=Math.max(left,right);
//         ans=Math.max(ans,till%2+till/2);
//         return ans;
//     }
    public int maxDistToClosest(int[] v) {
		int n = v.length;
		int b = 0, i = 0;
		while (v[i] == 0) {
			b++;
			i++;
		}
		int c = b, l = 0;
		for (; i < n; i++) {
			if (v[i] == 0)
				c++;
			else {
				l = Math.max(l, c);
				c = 0;
			}
		}
		l = l % 2+(l / 2);
		
		return Math.max(Math.max(l, c), b);
	}
}