import java.util.*;

class Solution {
    public int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        
        int[] curr = new int[N];                // 스테이지에 도달했으나 아직 클리어 못한 플레이어 수
        double[][] failRate = new double[N][2];     // 실패율 배열
        
        for(int i=0; i<stages.length; i++) {
            if( stages[i]-1 < N ) curr[stages[i]-1]++;
        }
        
        int total = stages.length;
        for(int i=0; i<N; i++) {
            failRate[i][0] = i+1;
            if( (total - (i > 0 ? curr[i-1] : 0)) > 0 ) failRate[i][1] = (double)curr[i] / (total - (i > 0 ? curr[i-1] : 0));
            else failRate[i][1] = 0;
            total = total - (i > 0 ? curr[i-1] : 0);
        }
        
        Arrays.sort(failRate, new Comparator<double[]> (){
            
            @Override
            public int compare(double[] o1, double[] o2) {
                if( o1[1] != o2[1] ) return Double.compare(o2[1], o1[1]);      // 실패율 내림차순
                else return (int)(o1[0] - o2[0]);                              // 번호 오름차순
            }
        });
        
        for(int i=0; i<N; i++) {
            System.out.println(failRate[i][1]);
        }
                                 
        for(int i=0; i<N; i++) {
            answer[i] = (int) failRate[i][0];
        }
        
        return answer;
    }
}