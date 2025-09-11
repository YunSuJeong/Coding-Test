import java.util.*;

class Solution {
    public int[][] solution(int[][] data, String ext, int val_ext, String sort_by) {
        int len = 0, idx = 0, sort = 0;
        Map<String, Integer> map = new HashMap<>();
        map.put("code", 0);
        map.put("date", 1);
        map.put("maximum", 2);
        map.put("remain", 3);
        
        for(int[] d : data) {
            if( d[map.get(ext)] < val_ext ) len++;
        }
        System.out.println(len);
        int[][] answer = new int[len][4];
        int i = 0;
        for(int[] d : data) {
            if( d[map.get(ext)] < val_ext ) {
                answer[i][0] = d[0];
                answer[i][1] = d[1];
                answer[i][2] = d[2];
                answer[i][3] = d[3];
                i++;
            }
        }
        System.out.println(Arrays.deepToString(answer));
        Arrays.sort(answer, new Comparator<int[]>() {
            
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[map.get(sort_by)] - o2[map.get(sort_by)];
            }
        });
        
        return answer;
    }
}