import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int[] arr;
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		// N개 수 배열에 저장
		arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st2.nextToken());
		}
		// 1. 시간초과
//		int cnt = 0;				// 경우의 수
//		for(int i=0; i<N; i++) {
//			for(int j=i; j<N; j++) {
//				// i~j번째 수들의 합
//				int sum = numSum(i, j, M);
//				if( sum == M ) cnt++;
//			}
//		}
//		System.out.println(cnt);
		
		// 2. 투포인터 
		int left = 0, right = 0, sum = 0, cnt = 0;
		while( left < N && right < N ) {
			sum += arr[right];
			
			if( sum < M ) {
				right++;
			} else {
				if( sum == M ) cnt++;
				left += 1;
				right = left;
				sum = 0;
			}
		}
		System.out.println(cnt);
	}
	
	/*public static int numSum(int i, int j, int M) {
		int sum = 0;
		for(int idx=i; idx<=j; idx++) {
			sum += arr[idx];
			
			if(sum > M) {
				sum = -1;
				break;
			}
		}
		return sum;
	}*/

}
