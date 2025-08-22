class Solution {
    public int[] solution(String s) {
        int[] answer = new int[s.length()];
        
        for(int i=0; i<s.length(); i++) {
            int idx = i-1;
            while( idx >= 0 ) {
                if( s.charAt(idx) == s.charAt(i) ) break;
                idx--;
            }
            answer[i] = idx < 0 ? idx : i - idx;
        }
        
        return answer;
    }
}