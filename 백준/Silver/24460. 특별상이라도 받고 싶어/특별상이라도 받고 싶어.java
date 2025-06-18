import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int N;
	public static int[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		arr = new int[N][N];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<N; j++) {
				arr[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		if( N > 1 ) prize(0, 0, 2);
		
		System.out.println(arr[0][0]);
	}
	
	public static void prize(int x, int y, int n) {
		for(int i=0; i<N; i+=n) {
			for(int j=0; j<N; j+=n) {
				findSec(i, j, n);
			}
		}

		if( n == N ) return;
		
		prize(x, y, n*2);
	}
	
	public static void findSec(int x, int y, int n) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=x; i<x+n; i+=n/2) {
			for(int j=y; j<y+n; j+=n/2) {
				list.add(arr[i][j]);
			}
		}
		
		Collections.sort(list);
		
		arr[x][y] = list.get(1);
	}

}
