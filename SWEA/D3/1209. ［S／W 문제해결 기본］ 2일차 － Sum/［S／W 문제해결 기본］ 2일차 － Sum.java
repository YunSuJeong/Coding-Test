import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			int T = Integer.parseInt(br.readLine());
			int[][] arr = new int[100][100];
			
			int sum = 0, max = Integer.MIN_VALUE;
			for(int i=0; i<100; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				sum = 0;
				for(int j=0; j<100; j++) {
					arr[i][j] = Integer.parseInt(st.nextToken());
					sum += arr[i][j];				// 행의 합
				}
				max = Integer.max(max, sum);
			}

			// 열의 합
			for(int i=0; i<100; i++) {
				sum = 0;
				for(int j=0; j<100; j++) {
					sum += arr[j][i];
				}
				max = Integer.max(max, sum);
			}
			
			// 대각선의 합
			int sum1 = 0, sum2 = 0;
			for(int i=0; i<100; i++) {
				sum1 += arr[i][i];
				sum2 += arr[i][99-i];
			}
			max = Integer.max(max, Math.max(sum1, sum2));
			
			System.out.printf("#%d %d\n", T, max);
		}
	}

}
