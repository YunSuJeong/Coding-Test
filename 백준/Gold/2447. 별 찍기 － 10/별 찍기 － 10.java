import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {
	
	public static int N;
	public static char[][] arr;
	public static String pattern = "*";

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		N = Integer.parseInt(br.readLine());
		arr = new char[N][N];
		
		star(0, 0, N);
		
		for(int i=0; i<N; i++) {
			for(int j=0; j<N; j++) {
				if( arr[i][j] == '\0' ) sb.append(" ");
				else sb.append(arr[i][j]);
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	public static void star(int x, int y, int n) {
		if( n == 1 ) return;
		
		if( n == 3 ) {
			for(int i=x; i<x+3; i++) {
				for(int j=y; j<y+3; j++) {
					if( !(i == x + 1 && j == y + 1) ) arr[i][j] = '*';
				}
			}
		}
		
		for(int i=x; i<x+n; i+=n/3) {
			for(int j=y; j<y+n; j+=n/3) {
				if( !(i == x + n/3 && j == y + n/3) ) star(i, j, n/3);
			}
		}
	}
}
