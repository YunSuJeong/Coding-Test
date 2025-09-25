class Solution {
    public int[] solution(String[] park, String[] routes) {
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
            
        int row = park.length, col = park[0].length();
        char[][] arr = new char[row][col];
        
        int sx = 0, sy = 0;             // 시작 위치
        for(int i=0; i<row; i++) {
            for(int j=0; j<col; j++) {
                arr[i][j] = park[i].charAt(j);
                if( park[i].charAt(j) == 'S' ) {
                    sx = i;
                    sy = j;
                }
            }
        }
        
        for(String r : routes) {
            String c = r.split(" ")[0];
            int n = Integer.parseInt(r.split(" ")[1]);
            int d = 0;
            boolean flag = true;
            int a = sx, b = sy;
            
            if( c.equals("S") ) d = 1;
            else if( c.equals("W") ) d = 2;
            else if( c.equals("E") ) d = 3;
            
            for(int i=1; i<=n; i++) {
                a += dx[d];
                b += dy[d];
                
                if( a < 0 || a >= row || b < 0 || b >= col || arr[a][b] == 'X' ) {
                    flag = false;
                    break;
                }
            }
            
            // 공원을 벗어나지 않고, 장애물도 만나지 않았다면 이동
            if( flag ) {
                sx = a;
                sy = b;
            }
        }
        
        return new int[] {sx, sy};
    }
}