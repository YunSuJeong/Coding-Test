class Solution {
    public int[] solution(int[] lottos, int[] win_nums) {
        int zero = 0, cnt = 0;
        boolean[] num = new boolean[47];
        
        for(int i=0; i<6; i++) {
            num[win_nums[i]] = true;
        }
        
        for(int i=0; i<6; i++) {
            if( lottos[i] == 0 ) zero++;
            else {
                if( num[lottos[i]] ) cnt++;
            }
        }
        
        int max = zero + cnt;
        int min = cnt;
        
        return new int[] {max < 2 ? 6 : 7-max, min < 2 ? 6 : 7-min};
    }
}