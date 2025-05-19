import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		boolean flag = true;
		char[] arr = new char[N];
		int arrow = 0;
		boolean[] alphaYn = new boolean[26];
		for(int i=0; i<K; i++) {
			StringTokenizer lukcy = new StringTokenizer(br.readLine());
			
			int cnt = Integer.parseInt(lukcy.nextToken());
			char alpha = lukcy.nextToken().charAt(0);
			
			int idx = (arrow + cnt) % N;
			
			if( arr[idx] == 0 ) {
				arr[idx] = alpha;
				arrow = idx;
				// 이미 사용한 알파벳이면 존재하는 행운바퀴가 아님
				if( alphaYn[alpha-65] ) {
					flag = false;
					break;
				} else {
					alphaYn[alpha-65] = true;
				}
			} else {
				if( arr[idx] != alpha ) {
					flag = false;
					break;
				} else {
					arrow = idx;
				}
			}
		}

		if( flag ) {
			for(int i=0; i<N; i++) {
				sb.append(arr[(arrow+N-i)%N] == 0 ? '?' : arr[(arrow+N-i)%N]);
			}
		}
		System.out.println(flag ? sb.toString() : "!");
	}

}
