import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int len = 4*(N-1)+1;
		int mid = len/2 + 1;
		
		for(int i=1; i<=len; i++) {
			int k = i > mid ? len-i+1 : i-1;
				for(int j=1; j<=len; j++) {
				if( i == 1 || i == len ) sb.append("*");
				else if( i % 2 == 0 ) {
					if( ( j <= k || j > len-k ) && j % 2 == 1 ) sb.append("*");
					else sb.append(" ");
				} else {
					if( ( j <= k || j > len-k )) {
						if( j % 2 == 1 ) sb.append("*");
						else sb.append(" ");
					}
					else sb.append("*");
				}
			}
			sb.append("\n");
		}
		
		System.out.println(sb.toString());
	}

}
