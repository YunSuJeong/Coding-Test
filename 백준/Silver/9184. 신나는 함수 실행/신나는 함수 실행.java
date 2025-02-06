import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = "";
		while( (str=br.readLine()) != null ) {
			StringTokenizer st = new StringTokenizer(str);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			// EOF
			if( a == -1 && b == -1 && c == -1 ) break;
			
			// DP
			int result = 1;
			if( a > 0 && b > 0 && c > 0 ) {
				int A = a, B = b, C = c;
				if( a > 20 || b > 20 || c > 20 ) {
					A = 20;
					B = 20;
					C = 20;
				}
				int[][][] arr =  new int[A+1][B+1][C+1];
				
				for(int i=0; i<=A; i++) {
					for(int j=0; j<=B; j++) {
						for(int k=0; k<=C; k++) {
							if( i <= 0 || j <= 0 || k <= 0 ) arr[i][j][k] = 1;
							else 
								arr[i][j][k] = arr[i-1][j][k] + arr[i-1][j-1][k] + arr[i-1][j][k-1] - arr[i-1][j-1][k-1]; 
						}
					}
				}
				
				result = arr[A][B][C];
			}
			sb.append("w("+a+", "+b+", "+c+") = "+result+"\n");
		}
		System.out.println(sb.toString());
	}

}
