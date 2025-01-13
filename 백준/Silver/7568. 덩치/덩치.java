import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		int arr[][] = new int[N][2];
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			arr[i][0] = Integer.parseInt(st.nextToken());			// 몸무게
			arr[i][1] = Integer.parseInt(st.nextToken());			// 키
		}
		
		// 본인보다 덩치 큰 사람 수 구하기
		for(int i=0; i<N; i++) {
			int cnt = 0;
			for(int j=0; j<N; j++) {
				if( i != j && arr[i][0] < arr[j][0] && arr[i][1] < arr[j][1] ) cnt++;
			}
			sb.append((cnt+1)+" ");
		}
		
		System.out.println(sb.toString());
	}

}
