class Solution {
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<schedules.length; i++) {
            int count = 0;
            for(int j=0; j<7; j++) {
                int h = schedules[i] / 100;
                int m = schedules[i] % 100 + 10;
                if( m >= 60 ) {
                    m -= 60;
                    h++;
                }
                int targetTm = h * 100 + m;
                int day = (startday + j) % 7;
                if( day > 0 && day <= 5 && timelogs[i][j] <= targetTm ) count++;
            }
            if( count == 5 ) answer++;
        }
        return answer;
    }
}