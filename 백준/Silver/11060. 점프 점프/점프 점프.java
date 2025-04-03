import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int[] jump = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			jump[i] = 10000;
		}
		
		jump[0] = 0;
		for(int i=0; i<N; i++) {
			if( jump[N-1] == 10000 ) {
				int end = i+arr[i] >= N ? N-1 : i+arr[i];
				for(int j=i+1; j<=end; j++) {
					jump[j] = Math.min(jump[j], jump[i] + 1);
				}
			}
		}
		System.out.println(jump[N-1] == 10000 ? -1 : jump[N-1]);
	}

}
