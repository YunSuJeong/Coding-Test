import java.util.*;

class Solution {
    public int solution(int[][] maps) {
        int n = maps.length;
        int m = maps[0].length;
        
        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};
        
        // dfs로 최단 거리
        Queue<int[]> queue = new LinkedList<int[]>();
        int[][] visited = new int[n][m];                // (i, j)까지 최단거리 및 0보다 크면 방문 O
        
        queue.offer(new int[]{0, 0});
        visited[0][0] = 1;
        visited[n-1][m-1] = -1;
        
        while( !queue.isEmpty() ) {
            int[] tmp = queue.poll();
            
            int x = tmp[0];
            int y = tmp[1];
            
            if( x == n-1 && y == m-1 ) break;
            
            for(int i=0; i<4; i++) {
                int a = x + dx[i];
                int b = y + dy[i];
                
                if( a >= 0 && a < n && b >= 0 && b < m && visited[a][b] <= 0 && maps[a][b] > 0 ) {
                    visited[a][b] = visited[x][y] + 1;
                    queue.offer(new int[]{a, b});
                }
            }
        }

        return visited[n-1][m-1];
    }
}