class Solution {
    public boolean isBipartite(int[][] graph) {
        int n = graph.length;
        int[] colors = new int[n]; // Array to store colors of nodes. Initially, all are 0 (uncolored).
        Arrays.fill(colors, -1); // -1 indicates uncolored nodes
        
        // Traverse all nodes (in case the graph is disconnected)
        for (int i = 0; i < n; i++) {
            if (colors[i] == -1) {  // If the node is not colored yet, start DFS from it
                if (!dfs(i, graph, colors, 0)) {
                    return false;  // If DFS returns false, graph is not bipartite
                }
            }
        }
        
        return true;  // If no conflicts found, the graph is bipartite
    }

    // DFS function to check bipartite
    private boolean dfs(int node, int[][] graph, int[] colors, int color) {
        colors[node] = color;  // Color the current node
        
        // Traverse all adjacent nodes
        for (int neighbor : graph[node]) {
            if (colors[neighbor] == -1) {
                // If neighbor is uncolored, color it with the opposite color
                if (!dfs(neighbor, graph, colors, 1 - color)) {
                    return false;  // If DFS returns false, the graph is not bipartite
                }
            } else if (colors[neighbor] == color) {
                // If neighbor has the same color, the graph is not bipartite
                return false;
            }
        }
        
        return true;  // No conflicts, continue DFS
    }

    
}
