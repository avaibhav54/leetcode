class Solution {
    public int largestRectangleArea(int[] heights) {
    Stack<Integer> stack = new Stack<>();
    int n = heights.length;
    int max =0;
    for(int i = 0; i<=n; i++)
    {
        while(!stack.isEmpty() && heights[stack.peek()] > (i==n?0 : heights[i]))
        {
            int j = stack.pop();
            int k = stack.isEmpty()? -1 : stack.peek();
            
            max = Math.max(max,heights[j]*(i-k-1));
        }
        stack.push(i);
    }
    
    return max;
    }
}