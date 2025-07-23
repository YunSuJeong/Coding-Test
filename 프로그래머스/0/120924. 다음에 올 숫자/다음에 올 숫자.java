class Solution {
    public int solution(int[] common) {
        int answer = 0;
        int a = common[0], b = common[1], c = common[2];
        int last = common.length - 1;
        
        if( b - a == c - b ) {
            answer = common[last] + (b-a);
        } else {
            answer = common[last] * (b/a); 
        }

        return answer;
    }
}