import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N+1];			// 계단 높이 저장
		for(int i=1; i<=N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		
		// 각 계단에서의 최대 점수 구하기
		int max[] = new int[N+1];
		max[1] = arr[1];
		for(int i=2; i<=N; i++) {
			if( i < 3 ) {
				max[i] = arr[i] + arr[i-1];
			} else {
				int score1 = arr[i] + arr[i-1] + max[i-3];			// 한 칸 : 현재 점수 + 1칸 전 점수 + 3칸 전 최대 점수
				int score2 = arr[i] + max[i-2];			// 두 칸 : 현재 점수 + 2칸 전 최대 점수
				max[i] = Math.max(score1, score2);
			}
		}
		System.out.println(max[N]);
	}
	
}
