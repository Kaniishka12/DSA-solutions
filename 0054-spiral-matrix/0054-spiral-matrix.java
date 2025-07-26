class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        
        ArrayList<Integer> a=new ArrayList<>();
        int sr=0;
        int sc=0;
        int er=matrix.length-1;
        int ec=matrix[0].length-1;
        while(sr<=er && sc<=ec){
           for(int j=sc;j<=ec;j++){
            a.add(matrix[sr][j]);
           }
           for(int i=sr+1;i<=er;i++){
            a.add(matrix[i][ec]);
           }
           for(int j=ec-1;j>=sc;j--){
            if(sr==er){
                break;
            }
            a.add(matrix[er][j]);
           }
           for(int i=er-1;i>sr;i--){
            if(sc==ec){
                break;
            }
            a.add(matrix[i][sc]);
            }
            sr++;
            sc++;
            er--;
            ec--;
        }
        return a;
    }
}
