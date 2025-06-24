class Solution {
    public int findPeakElement(int[] nums) {
        int low = 0;
        int high = nums.length - 1;

        while (low < high) {
            int mid = (low + high) / 2;

            if (nums[mid] > nums[mid + 1]) {
                // You are in a descending slope → move left
                high = mid;
            } else {
                // You are in an ascending slope → move right
                low = mid + 1;
            }
        }

        // low and high converge to a peak
        return low;
    }
}
