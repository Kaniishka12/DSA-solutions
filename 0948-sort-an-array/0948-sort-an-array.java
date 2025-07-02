class Solution {
    public int[] sortArray(int[] nums) {
       mergesort(nums,0,nums.length-1);
       return nums;
    }
    public void mergesort(int[] nums,int l,int h){
      
        if(l<h){
           int mid=(l+h)/2;
           mergesort(nums,l,mid);
        mergesort(nums,mid+1,h);
        merge(nums,l,mid,h);
        }
        

    }
    public void merge(int nums[],int l,int mid,int h){
        ArrayList<Integer> temp=new ArrayList<>();
        int i=l;
        int j=mid+1;
        while(i<=mid && j<=h){
            if(nums[i]<=nums[j]){
                temp.add(nums[i++]);
            }
            else{
                temp.add(nums[j++]);
            }
        }
        while(i<=mid){
            temp.add(nums[i++]);
        }
        while(j<=h){
            temp.add(nums[j++]);
        }
        for(int k=l;k<=h;k++){
            nums[k]=temp.get(k-l);
        }
    }
}

