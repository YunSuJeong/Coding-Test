class Solution {
    public int answer = 0;
    
    public int solution(int k, int[][] dungeons) {
        
        maxDungeon(0, dungeons, new boolean[dungeons.length], 0, k);
        
        return answer;
    }
    
    public void maxDungeon(int i, int[][] dungeons, boolean[] visited, int cnt, int k) {
        answer = Math.max(answer, cnt);
        
        for(int n=0; n<dungeons.length; n++) {
            if( !visited[n] && dungeons[n][0] <= k ) {
                visited[n] = true;
                maxDungeon(i+1, dungeons, visited, cnt+1, k-dungeons[n][1]);
                visited[n] = false;
            }
        }
    }
}