import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String rc = "";
		
		while( (rc=br.readLine()) != null ) {
			
			StringTokenizer st = new StringTokenizer(rc);
			
			int R = Integer.parseInt(st.nextToken());
			int C = Integer.parseInt(st.nextToken());
			
			// EOF
			if( R == 0 && C == 0 ) break;
			
			char arr[][] = new char[R][C];
			
			// 2차원 배열에 입력 저장
			for(int i=0; i<R; i++) {
				String str = br.readLine();
				for(int j=0; j<C; j++) {
					arr[i][j] = str.charAt(j);
				}
			}
			
			// 지뢰찾기
			for(int i=0; i<R; i++) {
				for(int j=0; j<C; j++) {
					if( arr[i][j] == '*' ) {
						sb.append("*");
					} else {
						// 인접한 8개 셀의 지뢰 개수
						int cnt = 0;
						if( i-1 >= 0 && j-1 >= 0) cnt = arr[i-1][j-1] == '*' ? cnt+1 : cnt;
						if( i-1 >= 0 ) cnt = arr[i-1][j] == '*' ? cnt+1 : cnt;
						if( i-1 >= 0 && j+1 < C ) cnt = arr[i-1][j+1] == '*' ? cnt+1 : cnt;
						if( j-1 >= 0 ) cnt = arr[i][j-1] == '*' ? cnt+1 : cnt;
						if( j+1 < C ) cnt = arr[i][j+1] == '*' ? cnt+1 : cnt;
						if( i+1 < R && j-1 >=0 ) cnt = arr[i+1][j-1] == '*' ? cnt+1 : cnt;
						if( i+1 < R ) cnt = arr[i+1][j] == '*' ? cnt+1 : cnt;
						if( i+1 < R && j+1 < C ) cnt = arr[i+1][j+1] == '*' ? cnt+1 : cnt;
						
						sb.append(cnt);
					}
				}
				sb.append("\n");
			}
		}
		
		System.out.println(sb.toString());
	}
}
