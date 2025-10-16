class Solution {
    
    public int zero = 0;    // 제거된 모든 0의 개수
    
    public int[] solution(String s) {
        int cnt = 0;        // 이진 변환 횟수
        
        while( !s.equals("1") ) {
            s = removeZero(s);
            s = Integer.toBinaryString(s.length());
            cnt++;
        }
        
        return new int[] {cnt, zero};
    }
    
    public String removeZero(String s) {
        int len = s.length();
        
        s = s.replace("0", "");
        zero += len - s.length();
        
        return s;
    }
}