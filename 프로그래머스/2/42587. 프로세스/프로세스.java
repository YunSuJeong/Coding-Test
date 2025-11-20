import java.util.*;

class Solution {
    public static int solution(int[] priorities, int location) {
        int answer = 0;
        
        int[] arr = new int[10];
        Queue<Integer> queue = new LinkedList<Integer>();
        int max = 0;
        
        for(int i=0; i<priorities.length; i++) {
            queue.offer(i);
            arr[priorities[i]]++;
            max = Math.max(max, priorities[i]);
        }
        
        while( !queue.isEmpty() ) {
            int p = queue.poll();
            if( priorities[p] < max ) {
                queue.offer(p);
            } else {
                answer++;
                arr[max]--;
                while( arr[max] <= 0 && max > 0 ) {
                    max--;
                }
                if( p == location ) break;
            }
        }
        
        return answer;
    }
}