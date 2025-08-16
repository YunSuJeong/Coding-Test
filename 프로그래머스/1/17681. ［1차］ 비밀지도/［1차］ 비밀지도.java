import java.util.*;

class Solution {
    public String[] solution(int n, int[] arr1, int[] arr2) {
        String[] answer = new String[n];
        StringBuilder sb = new StringBuilder();

        for(int i=0; i<n; i++) {
            int num1 = arr1[i], num2 = arr2[i];

            for(int j=0; j<n; j++) {
                if( num1 % 2 == num2 % 2 ) {
                    if( num1 % 2 == 0 ) sb.append(" ");
                    else sb.append("#");
                } else {
                    sb.append("#");
                }
                
                num1 /= 2;
                num2 /= 2;
            }
            
            answer[i] = sb.reverse().toString();
            sb.setLength(0);
        }
        
        return answer;
    }
}