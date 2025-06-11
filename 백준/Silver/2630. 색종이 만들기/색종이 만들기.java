import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int white = 0, blue = 0;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		cut(0, 0, N);
		
		System.out.println(white);
		System.out.println(blue);
	}
	
	public static void cut(int x, int y, int n) {
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
			if( tmp == 0 ) white++;
			else blue++;
			return;
		}
		
		if( n == 1 ) return;
		
		for(int i=x; i<x+n; i+=n/2) {
			for(int j=y; j<y+n; j+=n/2) {
				cut(i, j, n/2);
			}
		}
	}

}
