class Solution {
    public int compress(char[] chars) {
     
      int r=0;
      int w=0;
      while(r<chars.length){
           int c=0;
           char curr=chars[r];
           while(r<chars.length && chars[r]==curr){
               r++;
               c++;
               }
               chars[w]=curr;
               w++;
            if(c>1){
              for(char d:Integer.toString(c).toCharArray()){
                 chars[w]=d;
               w++;
              }
            }






      }
      return w;
       
    }
}