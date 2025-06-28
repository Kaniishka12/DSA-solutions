class Solution {
    public List<List<Integer>> subsets(int[] nums) {
    List<List<Integer>> ans=new ArrayList<>();
    List<Integer> ds=new ArrayList<>();
    int index=0;
    helper(nums,ans,ds,index);
    return ans;
    
}
public void helper(int[]nums,List<List<Integer>> ans,List<Integer> ds,int index){
    ans.add(new ArrayList<Integer>(ds));
    for(int i=index;i<nums.length;i++){
        ds.add(nums[i]);
        helper(nums,ans,ds,i+1);
        ds.remove(ds.size()-1);
    }
}
}