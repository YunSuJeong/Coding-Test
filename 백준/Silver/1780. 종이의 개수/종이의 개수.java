import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, zero = 0, one = 0, minus = 0;
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
		
		paper(0, 0, N);
		
		System.out.println(minus);
		System.out.println(zero);
		System.out.println(one);
	}
	
	public static void paper(int x, int y, int n) {
		int tmp = arr[x][y];

		// n*n인 종이가 모두 같은 수로 되어있는지 체크
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
		
		// 모두 같은 수로 되어있다면 카운팅 후 return
		if( flag ) {
			if( tmp == 1 ) one++;
			else if( tmp == 0 ) zero++;
			else minus++;
			return;
		} 
		
		// 종이를 더 이상 9개로 자를 수 없다면 종료
		if( n == 1 ) {
			return;
		}
		
		// 다른 수라면 9개로 자르기
		for(int i=x; i<x+n; i+=n/3) {
			for(int j=y; j<y+n; j+=n/3) {
				paper(i, j, n/3);
			}
		}
	}

}
