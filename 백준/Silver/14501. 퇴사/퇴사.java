import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, max = 0;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N+1][2];
		for(int i=1; i<=N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			arr[i][0] = Integer.parseInt(st.nextToken());
			arr[i][1] = Integer.parseInt(st.nextToken());
		}

		maxPay(1, 0);
		
		System.out.println(max);
	}
	
	public static void maxPay(int day, int pay) {
		if( day > N ) {
			max = Math.max(max, pay);
			return;
		}
		
		if( day + arr[day][0] <= N + 1 ) {
			maxPay(day + arr[day][0], pay + arr[day][1]);
		} 
		maxPay(day + 1, pay);
	}
	
}
