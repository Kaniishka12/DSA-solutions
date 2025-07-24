class Solution {
    public int findDuplicate(int[] nums) {
        ////use hashset 
 
        // Step 1: Detect cycle using Floyd's Algorithm
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];       // move 1 step
            fast = nums[nums[fast]]; // move 2 steps
        } while (slow != fast);

        // Step 2: Find the entry point of the cycle
        slow = nums[0];
        while (slow != fast) {
            slow = nums[slow];
            fast = nums[fast];
        }

        return slow; // or fast, both are now pointing to the duplicate
    }
}

    
