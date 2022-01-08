class MedianFinder {

    PriorityQueue<Integer> left;
    PriorityQueue<Integer> right;
    public MedianFinder() {
           left = new PriorityQueue<>(Collections.reverseOrder());
      right = new PriorityQueue<>();
    }    
    public void addNum(int val) {
        if(right.size()<left.size())
        {
            right.add(val);
        }
        else{
            left.add(val);
        }
      if(right.size()>0 && left.size()>0)
      while(right.peek()<left.peek())
      {
          int te=left.remove();
          int te2=right.remove();
          right.add(te);
          left.add(te2);
      }
    }
    
    public double findMedian() {
          if(left.size()==0)
      {
return -1;
} 
if(left.size()==right.size())
{
    int an=left.peek()+right.peek();
    double pr=(double)an/2;
    return pr;
}
return left.peek();
        
    }
}

/**
 * Your MedianFinder object will be instantiated and called as such:
 * MedianFinder obj = new MedianFinder();
 * obj.addNum(num);
 * double param_2 = obj.findMedian();
 */