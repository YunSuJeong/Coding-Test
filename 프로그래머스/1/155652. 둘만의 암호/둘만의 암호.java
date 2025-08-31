class Solution {
    public String solution(String s, String skip, int index) {
        StringBuilder sb = new StringBuilder();
        
        for(int i=0; i<s.length(); i++) {
            char c = s.charAt(i);
            int cnt = 0, tmp = c - 97;
            
            while( cnt < index ) {
                tmp += 1;
                
                if( tmp >= 26 ) tmp %= 26;              // z 넘어가는 경우 예외처리
                if( skip.indexOf(97+tmp) < 0 ) cnt++;   // skip에 없는 알파벳만 세기
            }
            
            sb.append((char)(97+tmp));
        }
        
        return sb.toString();
    }
}