import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		
		for(int i=0; i<T; i++) {
			int N = Integer.parseInt(br.readLine());
			
			int remain = 0, idx = 0;
			while(N > 0) {
				remain = N % 2;
				if( remain == 1 ) sb.append(idx+" ");
				idx++;
				N /= 2;
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
