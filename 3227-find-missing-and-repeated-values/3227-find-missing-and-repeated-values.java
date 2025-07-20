class Solution {
    public int[] findMissingAndRepeatedValues(int[][] grid) {
    int n=grid.length;
    int m=grid[0].length;
    HashSet<Integer> hs=new HashSet<Integer>();
    int[] arrr=new int[2];
    int a=0;
    int b=0;
    for(int i=0;i<n;i++){
        for(int j=0;j<m;j++){
            if(hs.contains(grid[i][j])){
                a=grid[i][j];
                arrr[0]=a;
                
            }
            hs.add(grid[i][j]);
        }
    }
    for(int i=1;i<=n*n;i++){
        if(!hs.contains(i)){
            b=i;
            arrr[1]=b;
        }
    }


return arrr;
    }
}