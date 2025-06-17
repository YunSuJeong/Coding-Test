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
		
		pooling(1);
		
		System.out.println(arr[0][0]);
	}

	// 풀링 반복
	public static void pooling(int n) {
		if( n == N ) return;
		
		for(int i=0; i<N; i+=n*2) {
			for(int j=0; j<N; j+=n*2) {
				findSecond(i, j, n);
			}
		}
		
		pooling(n*2);
	}
	
	// 2*2사각형 내 2번째로 큰 수를 맨 왼쪽상단에 배치
	public static void findSecond(int x, int y, int n) {
		List<Integer> list = new ArrayList<Integer>();
		
		for(int i=x; i<=x+n; i+=n) {
			for(int j=y; j<=y+n; j+=n) {
				list.add(arr[i][j]);
			}
		}
		
		Collections.sort(list);
		
		arr[x][y] = list.get(2);
	}
}
