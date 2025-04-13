import java.util.*;

class Solution {
    public int minCostConnectPoints(int[][] points) {
        int n = points.length;
        ArrayList<ArrayList<int[]>> adj = new ArrayList<>();

        // Initialize adjacency list
        for (int i = 0; i < n; i++) adj.add(new ArrayList<>());

        // Use Manhattan distance as required
        for (int i = 0; i < n; i++) {
            int[] u = points[i];
            for (int j = i + 1; j < n; j++) {
                int[] v = points[j];
                int dist = Math.abs(u[0] - v[0]) + Math.abs(u[1] - v[1]);

                adj.get(i).add(new int[]{j, dist});
                adj.get(j).add(new int[]{i, dist});
            }
        }

        int[] key = new int[n];
        int[] parent = new int[n];
        boolean[] mst = new boolean[n];
        Arrays.fill(key, Integer.MAX_VALUE);
        Arrays.fill(parent, -1);

        TreeSet<int[]> set = new TreeSet<>((a, b) -> {
            if (a[0] != b[0]) return a[0] - b[0];
            return a[1] - b[1];
        });

        key[0] = 0;
        set.add(new int[]{0, 0});

        while (!set.isEmpty()) {
            int[] top = set.pollFirst();
            int node = top[1];
            mst[node] = true;

            for (int[] neighbor : adj.get(node)) {
                int v = neighbor[0];
                int wt = neighbor[1];

                if (!mst[v] && wt < key[v]) {
                    set.remove(new int[]{key[v], v});
                    key[v] = wt;
                    parent[v] = node;
                    set.add(new int[]{key[v], v});
                }
            }
        }

        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum += key[i];
        }

        return sum;
    }
}
