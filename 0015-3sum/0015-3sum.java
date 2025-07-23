class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        if(nums==null||nums.length<3){
            return new ArrayList<>();
        }
        Set<List<Integer>> res=new HashSet<>();
        Arrays.sort(nums);
        for(int i=0;i<nums.length-2;i++){
            int l=i+1;
            int r=nums.length-1;
            while(l<r){
            int s=nums[l]+nums[r]+nums[i];
            if(s==0){
              res.add(Arrays.asList(nums[i],nums[l],nums[r]));
              l++;
              r--;
            }else if(s<0){
                l++;
            }else{
                r--;
            }}
        }
        return new ArrayList<>(res);
    }
}