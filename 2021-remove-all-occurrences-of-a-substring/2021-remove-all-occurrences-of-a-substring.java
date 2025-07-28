class Solution {
    public String removeOccurrences(String s, String part) {
            StringBuilder sk=new StringBuilder(s);
            while(sk.toString().contains(part)){
                 int index=sk.indexOf(part);
                sk.delete(index,index+part.length());
            }
return sk.toString();
    }
}