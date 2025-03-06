import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());
		int W = Integer.parseInt(st.nextToken());
		
		// 파스칼 삼각형 세팅
		int[][] arr = new int[31][31];
		for(int i=1; i<=30; i++) {
			for(int j=1; j<=30; j++) {
				if( j == 1 || j == i ) arr[i][j] = 1;
				else arr[i][j] = arr[i-1][j-1] + arr[i-1][j];
			}
		}
		
		// 합 구하기
		int sum = 0;
		for(int i=0; i<W; i++) {
			for(int j=0; j<=i; j++) {
				sum += arr[R+i][C+j];
			}
		}
		System.out.println(sum);
	}

}
