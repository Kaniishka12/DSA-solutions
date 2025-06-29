class Solution {
    public void solveSudoku(char[][] board) {
    helper(0,0,board);
    }
    private boolean helper(int row,int col,char[][] board){
        if(col==9){
            col=0;
            row++;
            if(row==9){
                return true;
            }
        }
        if(board[row][col]!='.'){
            return helper(row,col+1,board);
        }
        for(char c='1';c<='9';c++){
           if(isValid(row,col,board,c)){
            board[row][col]=c;
            if(helper(row,col+1,board)){
                return true;
            }
            board[row][col]='.';
            
           }

        }
        return false;
    }
    private boolean isValid(int row,int col,char[][] board,char c){
        for(int i=0;i<9;i++){
            if( board[i][col]==c){
                return false;
            }
        }
        for(int i=0;i<9;i++){
            if( board[row][i]==c){
                return false;
            }
        }
        int sr=(row/3)*3;
        int sc=(col/3)*3;
        for(int i=sr;i<sr+3;i++){
            for(int j=sc;j<sc+3;j++){
                if(board[i][j]==c){
                    return false;
                }
            }
        }
        return true;
    }

}