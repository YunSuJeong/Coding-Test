import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int kim = Integer.parseInt(st.nextToken());
		int lim = Integer.parseInt(st.nextToken());
		
		int round = 1;
		while( true ) {
			// 두 사람이 대결하는 조건 : 각 라운드의 갱신된 번호가 같을 때
			if( (kim+1)/2 == (lim+1)/2 ) break;
			round++;
			kim = (kim+1)/2;
			lim = (lim+1)/2;
		}
		System.out.println(round);
	}

}
