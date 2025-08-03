class Solution {
    public int solution(int[] absolutes, boolean[] signs) {
        int answer = 0;
        
        int idx = 0;
        for(int a : absolutes) {
            if( !signs[idx] ) a *= -1;
            answer += a;
            idx++;
        }
        
        return answer;
    }
}