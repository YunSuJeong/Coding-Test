import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		int num = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][N];
		
		int x = 0, y = 0;
		arr[x][y] = N*N;
		
		int cycle = 1;			// 방향전환을 위한 변수
		int cnt = N*N;
		arr[x][y] = cnt;
		
		while (true) {
			if( cycle == 1 ) {
				if( x+1 >= N || arr[x+1][y] > 0 ) cycle++;
				else {
					cnt--;
					x++;
				}
			} else if( cycle == 2 ) {
				if( y+1 >= N || arr[x][y+1] > 0 ) cycle++;
				else {
					cnt--;
					y++;
				}
			} else if( cycle == 3) {
				if( x-1 < 0 || arr[x-1][y] > 0 ) cycle++;
				else {
					cnt--;
					x--;
				}
			} else {
				if( y-1 < 0 || arr[x][y-1] > 0 ) cycle = 1;
				else {
					cnt--;
					y--;
				}
			}
			arr[x][y] = cnt;
			
			if( cnt == 1 ) break;
		}
		
		// 출력
		int a = 0, b = 0;
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				sb.append(arr[i][j]+" ");
				if( arr[i][j] == num ) {
					a = i+1;
					b = j+1;
				}
			}
			sb.append("\n");
		}
		sb.append(a+" "+b);
		System.out.println(sb.toString());
	}

}
