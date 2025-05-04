import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer doll = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		// 라이언 인형의 위치 저장
		List<Integer> lion = new ArrayList<Integer>();
		for(int i=0; i<N; i++) {
			if( Integer.parseInt(doll.nextToken()) == 1 ) lion.add(i);
		}
		
		int min = Integer.MAX_VALUE;
		// K개가 되는 최소 집합 크기 : i번째 라이언 위치 + (i+K-1)라이언 위치 + 1
		for(int i=0; i<lion.size(); i++) {
			if( i + K - 1 < lion.size() ) {
				min = Math.min(min, lion.get(i+K-1)-lion.get(i)+1);
			}
		}
		System.out.println(min == Integer.MAX_VALUE ? -1 : min);
	}

}
