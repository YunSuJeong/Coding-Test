import java.util.*;
class Solution {
    public List<Integer> solution(int[] arr, int[] query) {
    	List<Integer> answer = new ArrayList<Integer>();
    	for(int a : arr) {
    		answer.add(a);
    	}
    	
    	for(int i=0; i<query.length; i++) {
    		if( i % 2 == 0 ) {
    			int end = answer.size();
				for(int j=query[i]+1; j<end; j++) {
					answer.remove(answer.size()-1);
				}
    		} else {
    			for(int j=0; j<query[i]; j++) {
    				answer.remove(0);
    			}
    		}
    	}
        return answer;
    }
}