import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		long A = Long.parseLong(st.nextToken());
		long B = Long.parseLong(st.nextToken());
		
		long cnt = Math.abs(B-A)-1;
		System.out.println(cnt < 0 ? 0 : cnt);			// 두 수 사이 개수
		
		long start = A < B ? A : B;
		long end = A < B ? B : A;
		for(long i=start+1; i<end; i++) {
			sb.append(i+" ");
		}
		System.out.println(sb.toString().trim());
	}

}
