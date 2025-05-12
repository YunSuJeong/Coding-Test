import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		char[] arr = str.toCharArray();
		
		int len = str.length();
		int cntA = 0;	// A의 개수 = 연속되어야하는 길이
		for(int i=0; i<len; i++) {
			if( arr[i] == 'a' ) cntA++;
		}

		int min = Integer.MAX_VALUE;
		if( len == cntA || cntA == 0 ) min = 0;			// 문자열이 a로만 or b로만 이루어져있다면 교환 필요 없음
		else {
			for(int i=0; i<len; i++) {
				// 'ba'인 구간을 찾아 a의 위치부터 a의 개수만큼 탐색
				if( arr[i] == 'b' && arr[(i+1)%len] == 'a' ) {
					int cntB = 0;
					for(int j=(i+1)%len; j<(i+1)%len+cntA; j++) {
						// 연속된 구간에 b의 개수 = 교환 횟수
						if( arr[j%len] == 'b' ) cntB++;
					}
					// 해당 구간마다 최소 교환 횟수를 갱신
					min = Math.min(min, cntB);
				}
			}
		}
		System.out.println(min);
	}

}
