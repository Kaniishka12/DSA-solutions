class Solution {
    public int majorityElement(int[] nums) {
    int n=nums.length;
    int ele=0;
    int count=0;
    int check=0;
    for(int i=0;i<n;i++){
        if(count==0){
            ele=nums[i];
            count=1;
        }
        else if(nums[i]==ele){
            count++;
        }
        else{
            count--;
        }
    }
    for(int i=0;i<n;i++){
        if(nums[i]==ele){
            check++;
        }
    }
    if(check>(n/2)){
        return ele;
    }
    return -1;
    }
}