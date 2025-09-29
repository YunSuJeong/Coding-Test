import java.util.*;

class Solution {
    public int[] solution(String[] id_list, String[] report, int k) {
        int[] answer = new int[id_list.length];
        
        Map<String, Set<String>> report_list = new HashMap<>();
        for( String id : id_list ) report_list.put(id, new HashSet<String>());
        
        Map<String, Integer> map = new HashMap<>();
        
        for(String r : report) {
            String user = r.split(" ")[0];      // 이용자 id
            String repo = r.split(" ")[1];      // 신고한 id
            
            // 이용자가 신고한 적 없는 id라면 카운팅
            if( !report_list.get(user).contains(repo) ) map.put(repo, map.getOrDefault(repo, 0)+1);
            report_list.get(user).add(repo);
        }
        
        for(int i=0; i<id_list.length; i++) {
            int count = 0;
            for(String s : report_list.get(id_list[i])) {
                if( map.containsKey(s) && map.get(s) >= k ) count++;
            }
            answer[i] = count;
        }
        
        return answer;
    }
}