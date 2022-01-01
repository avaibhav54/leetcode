class Trie {

    /** Initialize your data structure here. */
      
    public class Node
    {
        Node child[];
        boolean isEnd;
            Node() {
        child = new Node[26];
      }
    }
     final private Node root;
    public Trie() {
root=new Node();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        Node curr=root;
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            char ch=word.charAt(i);
            if(curr.child[ch-'a']==null)
            {
                curr.child[ch-'a']=new Node();
            }
            curr=curr.child[ch-'a'];
            
            
        }
        curr.isEnd=true;
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
            Node curr=root;
        int n=word.length();
        for(int i=0;i<n;i++)
        {
            char ch=word.charAt(i);
        if(curr.child[ch-'a']==null)
            {
                return false;
            }
            curr=curr.child[ch-'a'];
        }
        return curr.isEnd;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
   Node curr=root;
        int n=prefix.length();
        for(int i=0;i<n;i++)
        {
            char ch=prefix.charAt(i);
        if(curr.child[ch-'a']==null)
            {
                return false;
            }
            curr=curr.child[ch-'a'];
        }
        return true;
    }
}

/**
 * Your Trie object will be instantiated and called as such:
 * Trie obj = new Trie();
 * obj.insert(word);
 * boolean param_2 = obj.search(word);
 * boolean param_3 = obj.startsWith(prefix);
 */