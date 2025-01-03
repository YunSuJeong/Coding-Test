import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String subjCd = br.readLine().substring(0, 5);
		int N = Integer.parseInt(br.readLine());
		
		int cnt = 0;
		for(int i=0; i<N; i++) {
			String subj = br.readLine();
			
			if( subjCd.equals(subj.substring(0, 5)) ) cnt++;
		}
		
		System.out.println(cnt);
	}

}
