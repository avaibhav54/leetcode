class Solution {
    public boolean wordPattern(String pattern, String s) {
        HashMap<Character,String>hm=new HashMap<>();
        int n=pattern.length();
        String arr[]=s.split(" ");
        if(n!=arr.length)return false;
        for(int i=0;i<n;i++)
        {
            if(!hm.containsKey(pattern.charAt(i)))
            {
                if(hm.containsValue(arr[i]))return false;
                hm.put(pattern.charAt(i),arr[i]);
            }
            else
            {
                if(!hm.get(pattern.charAt(i)).equals(arr[i]))return false;
            }
        }return true;
    }
}