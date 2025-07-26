class Solution {
    public int solution(int[][] board) {
        int[] X = {-1, -1, -1, 0, 1, 1, 1, 0};
        int[] Y = {-1, 0, 1, 1, 1, 0, -1, -1};
        
        int n = board[0].length;
        int danger = 0;
        for(int i=0; i<n; i++) {
            for(int j=0; j<n; j++) {
                if( board[i][j] == 1 ) {
                    danger++;
                    for(int k=0; k<8; k++) {
                        int a = i + X[k];
                        int b = j + Y[k];
                        if( a >= 0 && b >= 0 && a < n && b < n && board[a][b] == 0) {
                            danger++;
                            board[a][b] = 2;
                        }
                    }
                }
            }
        }
    
        int answer = n * n - danger;
        return answer;
    }
}