import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while( (str=br.readLine()) != null ) {
			
			StringTokenizer st = new StringTokenizer(str);
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			if( N == 0 && M == 0 ) break;
			
			// 상근, 선영이가 가진 CD번호 저장
			int[] arrN = new int[N];
			int[] arrM = new int[M];
			
			for(int i=0; i<N; i++) {
				arrN[i] = Integer.parseInt(br.readLine());
			}
			for(int i=0; i<M; i++) {
				arrM[i] = Integer.parseInt(br.readLine());
			}
			
			// 투포인터 기법으로 동시에 가지고 있는 CD개수 구하기
			int p1 = 0, p2 = 0, cnt = 0;	
			while( true ) {
				if( p1 >= N || p2 >= M ) break;
				
				if( arrN[p1] == arrM[p2] ) {
					p1++;
					p2++;
					cnt++;
				} else if( arrN[p1] < arrM[p2] ) {
					p1++;
				} else {
					p2++;
				}
			}
			System.out.println(cnt);
		}
	}

}
