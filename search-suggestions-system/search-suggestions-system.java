class Solution {
    public static class Node
    {
        Node child[];
        boolean isEnd;
        Node(){
            child=new Node[26];
            
        }
    }
    public static Node root;
    public static void insert(String str)
    {
        Node curr=root;
        for(char ch:str.toCharArray())
        {
            if(curr.child[ch-'a']==null)
            {
                curr.child[ch-'a']=new Node();
            }
            curr=curr.child[ch-'a'];
        }
        curr.isEnd=true;
    }
    public static  void wordsStartsWithHelper(Node node,List<String>l,StringBuilder str) {   
            if(l.size()==3)return;
        if(node==null)return;
        if(node.isEnd==true)
        {
            l.add(str.toString());
        }
           for(int i=0;i<26;i++){
              if(node.child[i]!=null){ 
                  if(l.size()==3)return;
                 
                 }
                  
                  wordsStartsWithHelper(node.child[i],l,str.append((char)('a'+i)));
               str.deleteCharAt(str.length()-1);
              }
          }
        
    public static List<String> startsWith(String str)
    {
        ArrayList<String>temp=new ArrayList<>();
        Node curr=root;
        for(char ch:str.toCharArray())
        {
            if(curr.child[ch-'a']==null)return temp;
            curr=curr.child[ch-'a'];
        }
        
        wordsStartsWithHelper(curr,temp,new StringBuilder(str));
        
        return temp;
    }
    public List<List<String>> suggestedProducts(String[] products, String searchWord) {
        List<List<String>>ans=new ArrayList<>();
        root=new Node();
        for(String str:products)
        {
            insert(str);
        }
        for(int i=1;i<=searchWord.length();i++)
        {
            String str=searchWord.substring(0,i);
          //  System.out.println(str);
            List<String>temp=startsWith(str);
            ans.add(temp);
        }
        return ans;
    }
}