import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[L+1];
		int[][] sign = new int[N][2];
		for(int i=1; i<=N; i++) {
			StringTokenizer s = new StringTokenizer(br.readLine());
			
			int D = Integer.parseInt(s.nextToken());
			int R = Integer.parseInt(s.nextToken());
			int G = Integer.parseInt(s.nextToken());
			
			arr[D] = i;
			sign[i-1][0] = R;
			sign[i-1][1] = G;
		}
		
		int sec = 0;
		for(int i=0; i<L; i++) {
			if( arr[i] > 0 ) {		// 신호등 있다면
				int red = sign[arr[i]-1][0];
				int green = sign[arr[i]-1][1];
				int cycle = red + green;
				// 현재 빨간불이라면 기다려야하는 시간 더하기
				if( sec % cycle < red ) 
					sec += red - (sec%cycle);
			}
			sec++;
		}
		System.out.println(sec);
	}

}
