import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int cnt = 0, N, K, sum = 0;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer nums = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(nums.nextToken());
		}
		
		subPermutation(0, 0);
		
		if( K == 0 ) cnt--;				// K가 0일때만 공집합 1개 빼기
		System.out.println(cnt);			
	}
	
	public static void subPermutation(int sum, int idx) {
		if( idx == N ) {
			if( sum == K ) cnt++;
			return;
		} 
		
		subPermutation(sum + arr[idx], idx+1);				// 현재 요소를 부분집합에 포함시키는 경우
		subPermutation(sum, idx+1);							// 현재 요소를 부분집합에 포함시키지 않는 경우
	}
}
