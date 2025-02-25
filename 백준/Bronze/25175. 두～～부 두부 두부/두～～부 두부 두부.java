import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

/*	두~~부 두부 두부 */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 1. 번호, 두부 번호 매핑
//		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
//		int mo = 3;
//		for(int i=M; i<M+N; i++) {
//			map.put(mo%N, i%N == 0 ? N : i%N);
//			mo++;
//		}
//		
//		int key = K % N;
//		if( key < 0 ) key += N;
//		System.out.println(map.get(key));
		
		// 2. 식으로 한번에 찾기
		int answer = (M + (K-3) % N + N) % N;
		System.out.println(answer == 0 ? N : answer);
	}

}
