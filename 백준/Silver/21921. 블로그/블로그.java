import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {	
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer V = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int X = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(V.nextToken());
		}
		
		int window = 0, max = 0, cnt = 0;
		for(int i=0; i<N; i++) {
			if( i < X ) window += arr[i];
			else {
				window = window - arr[i-X] + arr[i];
			}
			if( window > max ) {
				cnt = 1;
				max = window;
			} else if( window == max ) cnt++;
		}
		
		if( max == 0 ) System.out.println("SAD");
		else {
			System.out.println(max);
			System.out.println(cnt);
		}
	}

}
