import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 좌석 예매 현황
		int[][] arr = new int[N][M];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<M; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		if( M < K ) {
			System.out.println(0);
		} else {
			// 가로로 예매가능한 경우의 수 구하기
			int cnt = 0;
			for(int i=0; i<N; i++) {
				// 윈도우 초기화
				int sum = 0;
				for(int k=0; k<K; k++) {
					sum += arr[i][k];
				}
				// 맨앞좌석부터 가로로 예매 가능한 초기경우도 계산
				if( sum == 0 ) cnt++;
				// 윈도우 슬라이딩하면서 가로로 예매가능한지 확인
				for(int j=0; j<M-K; j++) {
					sum = sum - arr[i][j] + arr[i][j+K];
					if( sum == 0 ) cnt++;
				}
			}
			System.out.println(cnt);
		}
	}

}
