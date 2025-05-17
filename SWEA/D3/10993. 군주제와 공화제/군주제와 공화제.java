import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[][] city = new int[N][3];		// x, y, s
			for(int i=0; i<N; i++) {
				StringTokenizer st = new StringTokenizer(br.readLine());
				
				city[i][0] = Integer.parseInt(st.nextToken());
				city[i][1] = Integer.parseInt(st.nextToken());
				city[i][2] = Integer.parseInt(st.nextToken());
			}
			
			double[][] power = new double[N][N]; 			// i -> j 행사하는 영향력
			for(int i=0; i<N; i++) {
				for(int j=0; j<N; j++) {
					if( i != j ) {
						int x = Math.abs(city[i][0] - city[j][0]);
						int y = Math.abs(city[i][1] - city[j][1]);
						double p = city[i][2] * 1.0 / ( x * x + y * y );
						
						// 위협당하면 1
						if( p > city[j][2] ) power[j][i] = p;
					}
				}
			}
			
			String[] result = new String[N];
			for(int i=0; i<N; i++) {
				int cnt = 0, idx = 0;
				double max = Double.MIN_VALUE;
				for(int j=0; j<N; j++) {
					if( power[i][j] > 0 ) {
						if( max == Double.MIN_VALUE ) {
							max = power[i][j];
							cnt++;
							idx = j;
						} else if( max < power[i][j] ) {
							cnt = 1;
							max = power[i][j];
							idx = j;
						} else if( max == power[i][j] ) cnt++;
					}
				}
				if( cnt == 0 ) {
					result[i] = "K";
				} else if( cnt == 1 ) {
					result[i] = Integer.toString(idx+1);
				} else {
					result[i] = "D";
				}
			}
			
			for(String s : result) {
				if( !s.equals("K") && !s.equals("D") ) {
					int idx = Integer.parseInt(s)-1;
					while( true ) {
						if( result[idx].equals("K") || result[idx].equals("D") ) break;

						idx = Integer.parseInt(result[idx])-1;
					}
					sb.append((idx+1)+" ");
				} else {
					sb.append(s+" ");
				}
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
