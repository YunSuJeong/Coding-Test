import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String strA = br.readLine();
		String strB = br.readLine();
		StringTokenizer stA = new StringTokenizer(strA);
		StringTokenizer stB = new StringTokenizer(strB);
		
		int A[] = new int[N]; 
		int B[] = new int[N]; 
		for(int i=0; i<N; i++) {
			A[i] = Integer.parseInt(stA.nextToken());
			B[i] = Integer.parseInt(stB.nextToken());
		}
		
		Arrays.sort(A);
		Arrays.sort(B);
		
		int S = 0;
		for(int i=0; i<N; i++) {
			S += A[i]*B[N-i-1];
		}
		System.out.println(S);
	}

}
