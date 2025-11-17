import java.util.*;

class Solution {
    public int solution(int cacheSize, String[] cities) {
        int answer = 0;
        
        Queue<String> queue = new LinkedList<String>();

        for(String c : cities) {
            c = c.toLowerCase();
            if( queue.size() < cacheSize && !queue.contains(c) ) {
                answer += 5;
                queue.offer(c);
            } else if( !queue.contains(c) ) {
                answer += 5;
                queue.offer(c);
                queue.poll();
            } else {
                answer++;
                // 가장 오래 사용되지 않은 데이터 순서 변경
                int n = queue.size();
                for(int i=0; i<n; i++) {
                    if( queue.peek().equals(c) ) queue.poll();
                    else queue.offer(queue.poll());
                }
                queue.offer(c);
            }
        }
        
        return answer;
    }
}