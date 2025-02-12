import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=0; tc<T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int k = Integer.parseInt(st.nextToken());
			String str = st.nextToken();
			
//			Map<String, Integer> map = new HashMap<Integer, Integer>();			// 문자열 기반의 키를 사용하면 해시테이블 크기가 커지면서 메모리 초과될 위험이 있다.
			Map<Integer, Integer> map = new HashMap<Integer, Integer>();
			int[] arr = new int[4];
			int key;
			// 초기 윈도우 값 세팅
			for(int i=0; i<k; i++) {
				char c = str.charAt(i);
				if( c == 'A' ) arr[0] += 1;
				else if( c == 'G' ) arr[1] += 1;
				else if( c == 'T' ) arr[2] += 1;
				else arr[3] += 1;
			}
			key = arr[0] * 600 * 600 * 600 + arr[1] * 600 * 600 + arr[2] * 600 + arr[3];
			map.put(key, map.getOrDefault(key, 0)+1);
			
			for(int i=0; i<str.length()-k; i++) {
				// 1. 메모리 초과
//				String sub = str.substring(i, i+k);
//				
//				arr[0] = arr[1] = arr[2] = arr[3] = 0;
//				// A,G,T,C의 개수를 코드처럼 사용
//				for(int j=0; j<k; j++) {
//					char c = sub.charAt(j);
//					if( c == 'A' ) arr[0] += 1;
//					else if( c == 'G' ) arr[1] += 1;
//					else if( c == 'T' ) arr[2] += 1;
//					else arr[3] += 1;
//				}
				
				// 2. 슬라이딩 윈도우 기법 사용
				// 1) 이전 부분문자열의 맨 앞 문자 개수 빼기
				char remove = str.charAt(i);
				if( remove == 'A' ) arr[0]--;
				else if( remove == 'G' ) arr[1]--;
				else if( remove == 'T' ) arr[2]--;
				else arr[3]--;

				// 2) 다음 문자 개수 더하여 다음 부분문자열 구하기
				char add = str.charAt(i+k);
				if( add == 'A' ) arr[0]++;
				else if( add == 'G' ) arr[1]++;
				else if( add == 'T' ) arr[2]++;
				else arr[3]++;
				
				// k-부분 문자열의 등장 횟수 저장
				key = arr[0] * 600 * 600 * 600 + arr[1] * 600 * 600 + arr[2] * 600 + arr[3];
				map.put(key, map.getOrDefault(key, 0)+1);
			}
			
			// k-MCS 탐색
			int max = 0;
			for( int i : map.values() ) {
				max = Math.max(i, max);
			}
			sb.append(max+"\n");
		}
		System.out.println(sb.toString());
	}

}
