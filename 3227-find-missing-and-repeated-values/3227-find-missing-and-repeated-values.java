class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
     HashSet<Integer> s=new HashSet<>();
        int a=0;
        int b=0;
        int n=grid.length;
     for(int i=0;i<grid.length;i++){
         for(int j=0;j<grid[0].length;j++){
             if(s.contains(grid[i][j])){
                 a=grid[i][j];
             }
             s.add(grid[i][j]);
         }
     }
     for(int i=0;i<=n*n;i++){
         if(!s.contains(i)){
             b=i;
         }
     }
        return new int[] {a,b};
    }
}