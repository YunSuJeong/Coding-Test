import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[7];
			int s = -1, cnt = 0;					// 1주일 중 처음으로 수업하는 요일 저장
			for(int i=0; i<7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
				if( arr[i] > 0 ) {
					if( s == -1  ) s = i;
					cnt++;
				}
			}
			
			int remain = N % cnt;
			int week = N / cnt;
			if( remain == 0 ) {
				remain = cnt;
				week -= 1;
			}
			
			int min = 7;
			for(int i=0; i<7; i++) {
				if( arr[i] > 0 ) {
					s = i;
					int day = 0, count = 0;
					for(int j=s; j<s+7; j++) {
						if( count == remain ) break;
						if( arr[j%7] > 0 ) count++;
						day++;
					}
					min = Math.min(min, day);
				}
			}
			System.out.printf("#%d %d\n", tc, week * 7 + min);
		}
	}

}
