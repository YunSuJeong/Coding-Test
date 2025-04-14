import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int a = Integer.parseInt(st.nextToken());
		int b = Integer.parseInt(st.nextToken());
		int R = Integer.parseInt(br.readLine());
		
		boolean[][] flower = new boolean[R][R];
		flower[a][b] = true;
		
		int sec = 0;
		while( true ) {
			sec++;
			if( (a+1) + (b+1) < R ) {
				if( !flower[a+1][b+1] ) {
					a++;
					b++;
					flower[a][b] = true;
				}
				else break;
			} else {
				if( !flower[a/2][b/2] ) {
					a /= 2;
					b /= 2;
					flower[a][b] = true;
				}
				else break;
			}
		}
		System.out.println(sec);
	}

}
