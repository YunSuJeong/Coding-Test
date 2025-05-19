import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int D = Integer.parseInt(st.nextToken());
			
			StringTokenizer city = new StringTokenizer(br.readLine());
			int[] arr = new int[N];
			for(int i=0; i<N; i++) {
				arr[i] = Integer.parseInt(city.nextToken());
			}
			
			int broken = 0, min = 0;
			for(int i=0; i<N; i++) {
				if( arr[i] == 1 ) {
					// 연속으로 부서진 문이 D개 이상이면 차원문 재건 필요
					if( broken >= D ) {
						min += broken / D;
					} 
					broken = 0;
				} else {
					broken++;
				}
			}
			if( broken > 0 ) min += broken / D;
			System.out.printf("#%d %d\n", tc, min);
		}
	}

}
