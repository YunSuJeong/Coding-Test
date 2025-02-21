import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 세자리수
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=1; i<=9; i++) {
			for(int j=1; j<=9; j++) {
				if( i != j ) {
					for(int k=1; k<=9; k++) {
						if( k != j && i != k ) {
							int num = i*100 + j*10 + k;
							map.put(Integer.toString(num), 0);
						}
					}
				}
			}
		}
	
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String tmp = st.nextToken();
			int S = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			for(String key : map.keySet()) {
				int ball = 0, strike = 0;
				for(int k=0; k<3; k++) {
					if( tmp.indexOf(key.charAt(k)) >= 0 ) {
						if( key.charAt(k) == tmp.charAt(k) ) strike++;
						else ball++;
					}
				}
				// 볼&스트라이크 조건 만족하면 +1
				if( ball == B && strike == S ) map.put(key, map.get(key)+1);
			}
		}
		
		// 모든 조건을 만족하는 경우의 수 세기
		int cnt = 0;
		for(int value : map.values()) {
			if( value == N ) cnt++;
		}
		System.out.println(cnt);
	}

}
