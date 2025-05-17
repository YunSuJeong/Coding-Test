import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int minSet = Integer.MAX_VALUE, minOne = Integer.MAX_VALUE;
		for(int i=0; i<M; i++) {
			StringTokenizer brand = new StringTokenizer(br.readLine());
			
			int set = Integer.parseInt(brand.nextToken());
			int one = Integer.parseInt(brand.nextToken());
			
			minSet = Math.min(minSet, set);
			minOne = Math.min(minOne, one);
		}
		int min = Integer.MAX_VALUE;
		int cnt = N / 6;
		if( N % 6 > 0 ) cnt++;
		
		// 낱개로만 사기 vs 세트로만 사기 vs 세트 + 낱개로 사기
		min = Math.min(N*minOne, Math.min(cnt * minSet, minSet * (N/6) + minOne * (N%6)));
		System.out.println(min);
	}

}
