import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int arr[] = new int[N+1];
		int count = 0, num = 0;
		for(int i=2; i<=N; i++) {
			for(int j=i; j<=N; j+=i) {
				if( arr[j] == 0 ) {
					arr[j] += 1;
					count++;
				}
				if( count == K ) {
					num = j;
					break;
				}
			}
			if( num > 0 ) break;
		}
		System.out.println(num);
	}

}
