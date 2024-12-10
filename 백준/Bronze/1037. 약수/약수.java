import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

/*	약수 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		int min = 1000000, max = 2;
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			min = Math.min(min, num);
			max = Math.max(max, num);
		}
		
		// N = 가장 작은 약수 * 가장 큰 약수
		System.out.println(min*max);
	}

}
