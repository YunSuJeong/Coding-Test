import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String N = br.readLine();
		
		int arr[] = new int[9];
		for(int i=0; i<N.length(); i++) {
			if( N.charAt(i) == '9' ) arr[6] += 1;
			else arr[N.charAt(i)-'0'] += 1;
		}
		
		int max = 0, idx = 0, cnt = 0;
		for(int i=0; i<9; i++) {
			cnt = arr[i];
			if( i == 6 ) {
				if( arr[i] % 2 == 0 ) cnt = arr[i] / 2;
				else cnt = arr[i] / 2 + 1;
			}
			if( cnt > max ) {
				max = cnt;
				idx = i;
			}
		}

		System.out.println(max);
	}

}
