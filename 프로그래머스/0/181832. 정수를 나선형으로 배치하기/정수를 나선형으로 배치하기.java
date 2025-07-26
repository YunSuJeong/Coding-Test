class Solution {
    public int[][] solution(int n) {
        int[][] answer = new int[n][n];
        
        int[] dx = {0, 1, 0, -1};
        int[] dy = {1, 0, -1, 0};
        
        int d = 0, x = 0, y = 0;
        answer[0][0] = 1;
        
        while( true ) {
            if( answer[x][y] == n * n ) break;
            
            int a = x + dx[d];
            int b = y + dy[d];
            
            if( a >= 0 && b >= 0 && a < n && b < n && answer[a][b] == 0 ) {
                answer[a][b] = answer[x][y] + 1;
                x = a;
                y = b;
            } else {
                d = (d+1) % 4;
            }
        }
        
        return answer;
    }
}