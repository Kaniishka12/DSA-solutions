class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans=new ArrayList<>();
        List<Integer> ds=new ArrayList<>();
        helper(nums,ans,ds);
        return ans;
    }
    public void helper(int[] nums,List<List<Integer>> ans,List<Integer> ds){
        if(ds.size()==nums.length){
            ans.add(new ArrayList<Integer>(ds));
        }
        for(int num:nums){
            if(ds.contains(num)) continue;
            ds.add(num);
            helper(nums,ans,ds);
            ds.remove(ds.size()-1);
        }

    }

    
    
}

