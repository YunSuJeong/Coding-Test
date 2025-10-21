class Solution {
    public int[] solution(int brown, int yellow) {
        int[] answer = new int[2];
        
        int total = brown + yellow;
        int w = 0, h = 0;
        for(int i=1; i<=total; i++) {
            if( total % i == 0 ) {
                w = Math.max(i, total / i);
                h = Math.min(i, total / i);
                int y = (w-2) * (h-2);
                
                if( y == yellow ) {
                    answer[0] = w;
                    answer[1] = h;
                    break;
                }
            }
        }
        
        return answer;
    }
}