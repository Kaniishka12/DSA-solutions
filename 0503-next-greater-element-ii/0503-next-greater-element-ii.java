import java.util.*;

class Solution {
    public int[] nextGreaterElements(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        Arrays.fill(result, -1);  // Default to -1 if no greater element found
        Stack<Integer> stack = new Stack<>();

        // Iterate 2*n times to simulate circular array
        for (int i = 2 * n - 1; i >= 0; i--) {
            // Maintain a monotonic decreasing stack
            while (!stack.isEmpty() && stack.peek() <= nums[i % n]) {
                stack.pop();
            }

            // Only set result during the first pass
            if (i < n) {
                if (!stack.isEmpty()) {
                    result[i] = stack.peek();
                }
            }

            // Push current element for future comparisons
            stack.push(nums[i % n]);
        }
        
        return result;
    }


}
