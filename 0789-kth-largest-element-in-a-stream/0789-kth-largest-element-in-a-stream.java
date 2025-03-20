class KthLargest {
    private PriorityQueue<Integer> minHeap;
    private int k;

    public KthLargest(int k, int[] nums) {
        this.k = k;
        minHeap = new PriorityQueue<>(k); // Min-heap to store k largest elements
        
        for (int num : nums) {
            add(num); // Add initial elements to the heap
        }
    }
    
    public int add(int val) {
        minHeap.offer(val); // Add new value to the heap
        
        if (minHeap.size() > k) {
            minHeap.poll(); // Remove smallest to maintain size k
        }
        
        return minHeap.peek(); // The kth largest element
    }
}

/**
 * Your KthLargest object will be instantiated and called as such:
 * KthLargest obj = new KthLargest(k, nums);
 * int param_1 = obj.add(val);
 */