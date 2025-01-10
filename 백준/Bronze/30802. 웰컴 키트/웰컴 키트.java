import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer size = new StringTokenizer(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int T = Integer.parseInt(st.nextToken());
		int P = Integer.parseInt(st.nextToken());
		
		int cntT = 0;
		for(int i=0; i<6; i++) {
			int s = Integer.parseInt(size.nextToken());
			cntT += s % T > 0 ? s/T+1 : s/T;
		}
		
		System.out.println(cntT);
		System.out.printf("%d %d", N/P, N%P);
	}

}
