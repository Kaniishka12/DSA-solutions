class Solution {
    
    String[] map=new String[]{"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        ArrayList<String> ans=new ArrayList<>();
        if (digits.length() == 0) return ans;
        StringBuilder ds=new StringBuilder();
        int index=0;
        helper(digits,ans,ds,index);
        return ans;
    }
    public void helper(String digits,ArrayList<String> ans,StringBuilder ds,int index){
if(index==digits.length()){
    ans.add(ds.toString());
    return;
}
char ch=digits.charAt(index);
String str=map[ch-'0'];
for(char c:str.toCharArray()){
    ds.append(c);
    helper(digits,ans,ds,index+1);
    ds.deleteCharAt(ds.length()-1);
}

    }
}