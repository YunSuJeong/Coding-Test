import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static long X;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		X = Long.parseLong(st.nextToken());
		
		long layer = 1, patty = 1;
		for(int i=0; i<N; i++) {
			layer = layer * 2 + 3;		// 레벨-N 햄버거의 총 레이어 수
			patty = patty * 2 + 1;		// 레벨-N 햄버거의 총 패티 수 
		}
		
		System.out.println(eatenPatty(1, layer, patty));
	}
	
	public static long eatenPatty(long s, long l, long p) {
		if( l < 0 ) return 0;		// 레이어 0보다 작아지면 리턴
		
		if( X == s + l / 2 ) {		
			// 현재 레이어의 딱 중간까지 먹은 경우
			return p / 2 + 1;
		} else if( X < s + l / 2 + 1 ) {
			// 현재 레이어의 중간보다 적게 먹은 경우
			return eatenPatty(s+1, (l-3)/2, p/2);
		} else {
			// 현재 레이어의 중간보다 많이 먹은 경우 : (이전 레이어의 패티 + 1) + (오른쪽 부분 남은 패티 세기)
			return (p/2 + 1) + eatenPatty(s+l/2+1, (l-3)/2, p/2);
		}
	}

}
