import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		BigInteger arr[] = new BigInteger[N+1];
		
		for(int i=0; i<=N; i++) {
			if( i <= 1 ) arr[i] = BigInteger.valueOf(i);
			else arr[i] = arr[i-2].add(arr[i-1]);
		}
		System.out.println(arr[N]);
	}

}
