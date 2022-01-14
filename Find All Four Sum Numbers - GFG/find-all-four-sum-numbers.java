// { Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    public static void main(String[] args) throws IOException {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int tc = Integer.parseInt(br.readLine().trim());

        while (tc-- > 0) {
            String[] nk = br.readLine().trim().split(" ");
            int n = Integer.parseInt(nk[0]);
            int k = Integer.parseInt(nk[1]);

            String[] str = br.readLine().trim().split(" ");
            int[] a = new int[n];
            for (int i = 0; i < n; i++) {
                a[i] = Integer.parseInt(str[i]);
            }

            Solution sln = new Solution();
            ArrayList<ArrayList<Integer>> ans = sln.fourSum(a, k);
            for (ArrayList<Integer> v : ans) {
                for (int u : v) {
                    System.out.print(u + " ");
                }
                System.out.print("$");
            }
            if (ans.isEmpty()) {
                System.out.print(-1);
            }
            System.out.println();
        }
    }
}// } Driver Code Ends


// User function Template for Java

// arr[] : int input array of integers
// k : the quadruple sum required

class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] arr, int k) {
        // code here
        
    Arrays.sort(arr);
    return kSumHelper(arr, k, 4, 0);
    }
    
  public static ArrayList<ArrayList<Integer>> twoSum(int[] arr, int si, int ei, int target) {
ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    int left = si;
    int right = ei;

    while (left < right) {
      if (left != si && arr[left] == arr[left - 1]) {
        left++;
        continue;
      }

      int sum = arr[left] + arr[right];
      if (sum == target) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(arr[left]);
        list.add(arr[right]);
        res.add(list);

        left++;
        right--;
      } else if (sum > target) {
        right--;
      } else {
        left++;
      }
    }

    return res;
  }

  public static ArrayList<ArrayList<Integer>> kSumHelper(int[] nums, int target, int k, int si) {
    if (k == 2) {
      return twoSum(nums, si, nums.length - 1, target);
    }
    ArrayList<ArrayList<Integer>> res = new ArrayList<>();
    int n = nums.length;
    if (n < k) return res;
    // Arrays.sort(nums);
    for (int i = si; i <= n - k; i++) {
      if (i != si && nums[i] == nums[i - 1]) continue;
      ArrayList<ArrayList<Integer>> ans = kSumHelper(nums, target-nums[i], k - 1, i + 1);
      for (ArrayList<Integer> list : ans) {
        list.add(0,nums[i]);
        res.add(list);
      }
    }
    return res;
  }
    
    
}