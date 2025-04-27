import java.util.*;

class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        // Step 1: Build the graph
        Map<Integer, List<int[]>> graph = new HashMap<>();
        for (int[] flight : flights) {
            int u = flight[0];
            int v = flight[1];
            int price = flight[2];
            if (!graph.containsKey(u)) {
                graph.put(u, new ArrayList<>());
            }
            graph.get(u).add(new int[] {v, price});
        }

        // Step 2: Min-Heap to perform BFS-like process
        // We store (currentCost, currentCity, currentStopCount)
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]); 
        pq.offer(new int[] {0, src, 0});  // Start from src with 0 cost and 0 stops
        
        // Step 3: Create a visited array to track the minimum cost for each city with at most k stops
        int[][] dist = new int[n][k + 2]; // dist[i][j] is the minimum cost to reach city i with j stops
        for (int i = 0; i < n; i++) {
            Arrays.fill(dist[i], Integer.MAX_VALUE);
        }
        dist[src][0] = 0;

        // Step 4: BFS with priority queue (similar to Dijkstra's)
        while (!pq.isEmpty()) {
            int[] current = pq.poll();
            int cost = current[0];
            int city = current[1];
            int stops = current[2];
            
            // If we reached the destination, return the cost
            if (city == dst) {
                return cost;
            }
            
            // If we can still make more stops
            if (stops <= k) {
                // Explore all the neighbors
                for (int[] neighbor : graph.getOrDefault(city, new ArrayList<>())) {
                    int nextCity = neighbor[0];
                    int nextCost = neighbor[1];
                    
                    // If the new cost is better, process it
                    if (cost + nextCost < dist[nextCity][stops + 1]) {
                        dist[nextCity][stops + 1] = cost + nextCost;
                        pq.offer(new int[] {cost + nextCost, nextCity, stops + 1});
                    }
                }
            }
        }
        
        // If we finish processing without reaching dst, return -1
        return -1;
    }
}
