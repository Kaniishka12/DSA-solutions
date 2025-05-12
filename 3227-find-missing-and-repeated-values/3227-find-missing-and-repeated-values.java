class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
    int n=grid.length;
    int m=grid[0].length;
    int a=0;
    int b=0;
    HashSet<Integer> h=new HashSet<>();
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
         if(h.contains(grid[i][j])){
                 a=grid[i][j];
                
         }
         h.add(grid[i][j]);
    }
    }
    for(int i=1;i<=n*n;i++){
        if(!h.contains(i)){
            b=i;
            break;
        }
    }
    return new int[]{a,b};
    }
}