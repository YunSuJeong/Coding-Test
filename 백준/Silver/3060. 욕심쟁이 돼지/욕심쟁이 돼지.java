import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			long N = Long.parseLong(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			// [i][0] : 전날 먹었던 양, [i][1] : 오늘 먹는 양
			long[][] arr = new long[6][2];
			long feed = N;
			for(int j=0; j<6; j++) {
				arr[j][0] = Integer.parseInt(st.nextToken());
				feed -= arr[j][0];
			}
			
			int day = 1;
			while( true ) {
				if( feed < 0 ) break;
				
				feed = N;
				for(int k=0; k<6; k++) {
					arr[k][1] = arr[k][0];
					arr[k][1] += (arr[(k+1)%6][0] + arr[(k+3)%6][0] + arr[(k+5)%6][0]);
					feed -= arr[k][1];
				}
				
				for(int k=0; k<6; k++) {
					arr[k][0] = arr[k][1];
				}
				day++;
			}
			sb.append(day+"\n");
		}
		System.out.println(sb.toString());
	}

}
