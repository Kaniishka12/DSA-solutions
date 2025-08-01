import java.util.*;
class Solution {
 
  public int orangesRotting(int[][] grid) {
    int n=grid.length;
    int m=grid[0].length;
    Queue<int[]>q=new LinkedList<>();
    int fo=0;
    int time=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(grid[i][j]==2){
                q.add(new int[]{i,j,0});

            }else if(grid[i][j]==1){
                     fo++;
            }

        }
    }
    if(fo==0){
        return 0;
    }
    int[] row={-1,0,1,0};
    int[] col={0,1,0,-1};
    while(!q.isEmpty()){
        int[] cell=q.poll();
        int r=cell[0];
        int c=cell[1];
        int t=cell[2];
        time=Math.max(time,t);
        for(int i=0;i<4;i++){
            int nrow=r+row[i];
            int ncol=c+col[i];
            if(nrow>=0 && nrow<n && ncol>=0 &&ncol<m && grid[nrow][ncol]==1){
                grid[nrow][ncol]=2;
                fo--;
                q.add(new int[]{nrow,ncol,t+1});
            } 
        }

    }
    if(fo==0){
        return time;
    }
return -1;













  }}
   