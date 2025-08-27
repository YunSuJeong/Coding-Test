class Solution {
    public int solution(String s) {
        int answer = 0;
        
        char x = 'a';
        int same = 0, diff = 0, idx = 0;
        
        while( s.length() > 0 ) {
            if( idx == 0 ) {
                x = s.charAt(idx);
                same++;
            } else if( x == s.charAt(idx) ) {
                same++;
            } else {
                diff++;
            }
            
            idx++;
            
            if( same == diff ) {
                s = s.substring(idx, s.length());
                idx = 0;
                answer++;
            }
            
            // 두 횟수가 다른 상태에서 더 이상 읽을 글자가 없는 경우 예외처리
            if( s.length() > 0 && idx >= s.length() ) {
                answer++;
                break;
            }
        }
        
        return answer;
    }
}