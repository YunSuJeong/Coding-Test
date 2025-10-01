import java.util.*;

class Solution {
    public int solution(int n, int w, int num) {
        int[] arr = new int[w+1];           // 각 열에 쌓여있는 상자의 개수
        Arrays.fill(arr, n/w);
        
        int remain = n % w;
        if( remain > 0 ) {
            int c = remain == 0 ? w : remain;
            if( (n/w + 1) % 2 == 0 ) {      // n이 존재하는 행이 짝수번째 행일 때
                for(int i=w; i>=(w+1)-c; i--) {
                    arr[i]++;
                }
            } else {
                for(int i=1; i<=c; i++) {
                    arr[i]++;
                }
            }
        }
        
        int row = num % w == 0 ? num/w : num/w + 1;     // 꺼내려는 상자의 행의 위치
        int col = num % w == 0 ? w : num % w;           // 꺼내려는 상자의 열의 위치
        if( row % 2 == 0 ) col = (w+1) - col;

        return arr[col] - row + 1;
    }
}