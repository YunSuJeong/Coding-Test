import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static char[][] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int size = (int) Math.pow(5, N);
		arr = new char[size][size];
		
		if( N == 0 ) System.out.println("*");
		else {
			star(0, 0, size, 0, 0);
			
			for(int i=0; i<size; i++) {
				for(int j=0; j<size; j++) {
					if( arr[i][j] == '\0' ) sb.append(" ");
					else sb.append(arr[i][j]);
				}
				sb.append("\n");
			}
			System.out.println(sb.toString());
		}
	}

	// star(행, 열, 현재 길이, 실제 별을 찍어야하는 위치x, 위치y)
	public static void star(int r, int c, int n, int px, int py) {
		// 더 나눌수 없다면 별로 채우기
		if( n == 1 ) {
			if( ((r == 0 || r == 1) && c == 2) 
					|| r == 2 
					|| (r == 3 && (c == 1 || c == 2 || c == 3)) 
					|| (r == 4 && (c == 1 || c == 3)) ) {
				arr[px][py] = '*';
			} 
			return;
		}
	
		// 현재 별 안에 별을 찍을 수 있다면, 현재
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				if( ((i == 0 || i == 1) && j == 2) 
						|| i == 2 
						|| (i == 3 && (j == 1 || j == 2 || j == 3)) 
						|| (i == 4 && (j == 1 || j == 3)) ) 
					star(i, j, n/5, px + i*n/5, py + j*n/5);
			}
		}
	}
}
