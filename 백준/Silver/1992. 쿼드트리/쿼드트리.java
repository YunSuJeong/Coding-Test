import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int[][] arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			for(int j=0; j<N; j++) {
				arr[i][j] = str.charAt(j) - '0';
			}
		}
		
		quadTree(0, 0, N);
		
		System.out.println(sb.toString());
	}
	
	public static void quadTree(int x, int y, int n) {
		// 주어진 영상이 모두 같은 수인지 체크
		int tmp = arr[x][y];
		boolean flag = true;
		
		for(int i=x; i<x+n; i++) {
			for(int j=y; j<y+n; j++) {
				if( tmp != arr[i][j] ) {
					flag = false;
					break;
				}
			}
			if( !flag ) break;
		}
		
		if( flag ) {
			if( tmp == 0 ) sb.append("0");
			else sb.append("1");
			return;
		}
		
		if( n == 1 ) {
			return;
		}
		
		sb.append("(");
		for(int i=x; i<x+n; i+=n/2) {
			for(int j=y; j<y+n; j+=n/2) {
				quadTree(i, j, n/2);
			}
		}
		sb.append(")");
	}
}
