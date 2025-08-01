class Solution {
    public int solution(int[][] dots) {
        int answer = 0;
        
        // 두 직선 선택하는 경우
        int[][] line1 = {{0,1}, {0,2}, {0,3}};
        int[][] line2 = {{2,3}, {1,3}, {1,2}};
        
        for(int i=0; i<3; i++) {
            if( answer > 0 ) break;
            
            int dot1 = line1[i][0];
            int dot2 = line1[i][1];
            int dot3 = line2[i][0];
            int dot4 = line2[i][1];
            
            // 직선1, 2의 x/y증가량
            int inc_x1 = dots[dot1][0]-dots[dot2][0];
            int inc_y1 = dots[dot1][1]-dots[dot2][1];
            int inc_x2 = dots[dot3][0]-dots[dot4][0];
            int inc_y2 = dots[dot3][1]-dots[dot4][1];
            
            int gcd1 = gcd(inc_x1, inc_y1);
            int gcd2 = gcd(inc_x2, inc_y2);
            
            if( inc_x1 / gcd1 == inc_x2 / gcd2 && inc_y1 / gcd1 == inc_y2 / gcd2 ) answer++;
        }
        
        return answer;
    }
    
    public int gcd(int a, int b) {
        if( a % b == 0 ) return b;
        else return gcd(b, a%b);
    }
}