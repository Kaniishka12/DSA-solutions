import java.util.*;
class Solution {
  //Function to find minimum time required to rot all oranges. 
  public int orangesRotting(int[][] grid) {
    // figure out the grid size
    int n = grid.length;
    int m = grid[0].length;
    // n x m 
    Queue < Pair > q = new LinkedList < > ();
    // n x m 
    int[][] vis = new int[n][m];
    int cntFresh = 0;

    for (int i = 0; i < n; i++) {
      for (int j = 0; j < m; j++) {
        // if cell contains rotten orange
        if (grid[i][j] == 2) {
          q.add(new Pair(i, j, 0));
          // mark as visited (rotten) in visited array
          vis[i][j] = 2;
        }
        // if not rotten
        else {
          vis[i][j] = 0;
        } 

        // count fresh oranges
        if (grid[i][j] == 1) cntFresh++;
      }
    }

    int tm = 0;
    // delta row and delta column
    int drow[] = {-1, 0, +1, 0};
    int dcol[] = {0, 1, 0, -1}; 
    int cnt = 0;

    // until the queue becomes empty
    while (!q.isEmpty()) {
      int r = q.peek().row;
      int c = q.peek().col;
      int t = q.peek().tm;
      tm = Math.max(tm, t);
      q.remove();
      // exactly 4 neighbours
      for (int i = 0; i < 4; i++) {
        int nrow = r + drow[i];
        int ncol = c + dcol[i];
        // check for valid coordinates and 
        // then for unvisited fresh orange
        if (nrow >= 0 && nrow < n && ncol >= 0 && ncol < m &&
          vis[nrow][ncol] == 0 && grid[nrow][ncol] == 1) {
          // push in queue with timer increased
          q.add(new Pair(nrow, ncol, t + 1));
          // mark as rotten
          vis[nrow][ncol] = 2;
          cnt++;
        }
      }
    }

    // if all oranges are not rotten
    if (cnt != cntFresh) return -1;
    return tm;
  }

 

}

class Pair {
  int row;
  int col;
  int tm;
  Pair(int _row, int _col, int _tm) {
    this.row = _row;
    this.col = _col;
    this.tm = _tm;
  }
}