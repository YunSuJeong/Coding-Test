class Solution {
    public String solution(int a, int b) {
        String[] day = {"FRI", "SAT", "SUN", "MON", "TUE", "WED", "THU"};
        
        int sum = b-1;
        for(int i=1; i<a; i++) {
            if( i == 2 ) sum += 29;
            else if( i == 4 || i == 6 || i == 9 || i == 11 ) sum += 30;
            else sum += 31;
        }
        
        return day[sum%7];
    }
}