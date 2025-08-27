import java.util.*;

class Solution {
    public int solution(String dartResult) {
        int[] scores = new int[3];
	        
	        int round = 0, s, e;
	        int S, D, T, score;
	        char bonus = 'S', option;
	        while( round < 3 ) {
	            // 각 라운드 점수 및 라운드 마지막 인덱스 초기화
	            score = 0;
	            s = 0;
	            e = Integer.MAX_VALUE;
	            
	            // 보너스 기준점 찾기
	            S = dartResult.indexOf('S');
	            D = dartResult.indexOf('D');
	            T = dartResult.indexOf('T');
	            
	            if( S >= 0 && S < e ) {
	                e = S;
	                bonus = 'S';
	            }
	            if( D >= 0 && D < e ) {
	                e = D;
	                bonus = 'D';
	            }
	            if( T >= 0 && T < e ) {
	                e = T;
	                bonus = 'T';
	            }
	            
	            score = Integer.parseInt(dartResult.substring(s, e));
	            if( e + 1 < dartResult.length() ) option = dartResult.charAt(e+1);
                else option = '.';
	            
	            // 보너스 계산
	            if( bonus == 'D' ) score *= score;
	            else if( bonus == 'T' ) score *= score * score;
	            
	            // 옵션 계산
	            if( option  == '*' ) {
	                if( round > 0 ) scores[round-1] *= 2;
	                score *= 2;
	                e++;
	            } else if( option == '#' ) {
	                score *= -1;
	                e++;
	            }
	            
	            // 다음 라운드를 위한 세팅
	            scores[round] = score;
	            dartResult = dartResult.substring(e+1, dartResult.length());
	            round++;
	        }
	        
	        return scores[0] + scores[1] + scores[2];
    }
}