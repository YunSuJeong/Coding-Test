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
		
		// 각 열의 합을 1차원 배열에 저장
		int[] arr = new int[M];
		for(int i=0; i<N; i++) {
			StringTokenizer Q = new StringTokenizer(br.readLine());
			for(int j=0; j<M; j++) {
				arr[j] += Integer.parseInt(Q.nextToken());
			}
		}
		
		// 윈도우 크기 = 열의 개수
		int A = Integer.parseInt(br.readLine());
		
		// 윈도우 초기 세팅
		int max = 0;
		for(int i=0; i<A; i++) {
			max += arr[i];
		}
		
		// 가장 많이 박수를 친 구간 찾기
		int next = max;
		for(int i=0; i<M-A; i++) {
			next = next - arr[i] + arr[i+A];
			max = Math.max(max, next);
		}
		System.out.println(max);
	}

}
