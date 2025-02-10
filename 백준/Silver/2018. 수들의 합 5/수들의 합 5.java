import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int left = 1, right = 2, sum = left;
		int cnt = 1;
		while( true ) {
			sum += right;
			if( left > N || right > N ) break;
			
			if( sum < N ) right++;
			else if( sum >= N ) {
				if( sum == N ) cnt++;
				left += 1;
				right = left + 1;
				sum = left;
			}
		}
		System.out.println(cnt);
	}

}
