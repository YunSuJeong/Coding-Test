import java.util.*;

class Solution {
    public List<Integer> solution(String today, String[] terms, String[] privacies) {
        List<Integer> answer = new ArrayList<>();
        int YYYY = Integer.parseInt(today.split("\\.")[0]);
        int MM = Integer.parseInt(today.split("\\.")[1]);
        int DD = Integer.parseInt(today.split("\\.")[2]);
        
        Map<String, Integer> map = new HashMap<>();
        for(String t : terms) {
            map.put(t.split(" ")[0], Integer.parseInt(t.split(" ")[1]));
        }
        
        for(int i=0; i<privacies.length; i++) {
            String info = privacies[i].split(" ")[0];
            String type = privacies[i].split(" ")[1];
            int period = map.get(type);
            
            int year = Integer.parseInt(info.split("\\.")[0]);
            int month = Integer.parseInt(info.split("\\.")[1]) + period;
            int day = Integer.parseInt(info.split("\\.")[2]);
            
            if( month > 12 ) {
                year += month / 12;
                if( month % 12 == 0 ) year--;
                month = month % 12 == 0 ? 12 : month % 12;
            }
            
            if( ( (year < YYYY) || (year == YYYY && month < MM )) || (year == YYYY && month == MM && day <= DD) ) answer.add(i+1);
        }
        
        return answer;
    }
}