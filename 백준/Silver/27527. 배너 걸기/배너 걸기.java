import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer A = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(A.nextToken());
		}
		
		int count = 9 * M / 10;
		if( 9 * M % 10 != 0 ) count++;
		
		// 초기 윈도우 맵에 저장 (높이, 해당 구간에서 같은 높이 개수)
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();
		String result = "NO";
		int max = 0;
		for(int i=0; i<M; i++) {
			int cnt = map.getOrDefault(arr[i], 0)+1;
			map.put(arr[i], cnt);
			max = Math.max(max, cnt);
		}
		if( max >= count ) result = "YES";
		
		// 나머지 구간 탐색
		for(int i=0; i<N-M; i++) {
			map.put(arr[i], map.get(arr[i])-1);
			int cnt = map.getOrDefault(arr[i+M], 0)+1;
			map.put(arr[i+M], cnt);
			
			max = Math.max(max, cnt);
			
			if( max >= count ) {
				result = "YES";
				break;
			}
		}
		
		System.out.println(result);
	}

}
