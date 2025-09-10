import java.util.*;

class Solution {
    public String solution(String X, String Y) {
        StringBuilder sb = new StringBuilder();
        
        int[] xArr = new int[10];
        int[] yArr = new int[10];
        
        for(int i=0; i<X.length(); i++) xArr[X.charAt(i)-'0']++;
        for(int i=0; i<Y.length(); i++) yArr[Y.charAt(i)-'0']++;
        
        for(int i=9; i>=0; i--) {
            for(int j=0; j<Math.min(xArr[i], yArr[i]); j++) {
                sb.append(i);
            }
        }
        return sb.length() == 0 ? "-1" : sb.toString().replace("0", "").length() == 0 ? "0" : sb.toString();
    }
}