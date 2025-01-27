import java.util.*;

class Solution {
    private void findCombinations(int index, int[] arr, int target, List<List<Integer>> ans, List<Integer> ds) {
        // Base condition: If the index reaches the end of the array
        if (index == arr.length) {
            if (target == 0) {
                ans.add(new ArrayList<>(ds)); // Add valid combination
            }
            return;
        }

        // Pick the current element if it does not exceed the target
        if (arr[index] <= target) {
            ds.add(arr[index]); // Add current element
            findCombinations(index, arr, target - arr[index], ans, ds); // Recur (allow picking again)
            ds.remove(ds.size() - 1); // Backtrack
        }

        // Skip the current element and move to the next
        findCombinations(index + 1, arr, target, ans, ds);
    }

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>(); // Stores all valid combinations

        if (candidates.length == 0) return ans; // Edge case: Empty input array

        findCombinations(0, candidates, target, ans, new ArrayList<>()); // Call helper function
        return ans;
    }
}
