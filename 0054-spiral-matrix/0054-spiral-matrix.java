class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> a = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return a;
        }

        int sr = 0; // Start row
        int sc = 0; // Start column
        int er = matrix.length - 1; // End row
        int ec = matrix[0].length - 1; // End column

        while (sr <= er && sc <= ec) {
            for (int j = sc; j <= ec; j++) {
                a.add(matrix[sr][j]);
            }
            for (int i = sr + 1; i <= er; i++) {
                a.add(matrix[i][ec]);
            }
            for (int j = ec - 1; j >= sc; j--) {
                if (sr == er) {
                    break;
                }
                a.add(matrix[er][j]);
            }
            for (int i = er - 1; i >= sr + 1; i--) {
                if (sc == ec) {
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