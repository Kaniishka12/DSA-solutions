class Solution {
    public int compress(char[] chars) {
     
     int r=0;
     int w=0;
     while(r<chars.length){
        char cc=chars[r];
        int cn=0;
        while(r<chars.length && chars[r]==cc){
            r++;
            cn++;
        }
        chars[w]=cc;
        w++;
        if(cn>1){
            for(char c:Integer.toString(cn).toCharArray()){
                chars[w]=c;
                w++;
            }
        }
     





      }
      return w;
       
    }
}