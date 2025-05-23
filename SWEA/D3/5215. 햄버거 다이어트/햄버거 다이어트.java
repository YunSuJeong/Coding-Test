import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {
	
	public static int N, L, max = Integer.MIN_VALUE;
	public static int[] T, K;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int TC = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=TC; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			N = Integer.parseInt(st.nextToken());
			L = Integer.parseInt(st.nextToken());
			
			T = new int[N];
			K = new int[N];
			for(int i=0; i<N; i++) {
				StringTokenizer ingre = new StringTokenizer(br.readLine());
				
				T[i] = Integer.parseInt(ingre.nextToken());
				K[i] = Integer.parseInt(ingre.nextToken());
			}
			
			hamburger(0, 0, 0);
			
			System.out.printf("#%d %d\n", tc, max);
			max = Integer.MIN_VALUE;
		}
	}
	
	public static void hamburger(int n, int score, int kcal) {
		if( n == N ) {
			if( kcal <= L ) max = Math.max(max, score);
			return;
		}
		
		hamburger(n+1, score + T[n], kcal + K[n]);
		hamburger(n+1, score, kcal);
	}

}
