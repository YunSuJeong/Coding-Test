import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[N];
		int[] leftCnt = new int[N];		// 현재 i번째 자리에서 왼쪽에 키 큰 사람 수
		int[] line = new int[N];		// 줄을 선 순서
		
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
			leftCnt[i] = i;
		}
		
		for(int i=0; i<N; i++) {
			int p = -1;					// (i+1)번째 사람의 줄 선 위치
			for(int j=0; j<N; j++) {
				if( arr[i] == leftCnt[j] ) {
					leftCnt[j] = -1;
					p = j;
					line[j] = i + 1;
				}
				
				// (i+1)번째 사람의 줄 선 위치 뒤부터는 키 큰 사람이 1명씩 감소
				if( p >= 0 ) leftCnt[j]--;
			}
		}
		
		for(int l : line) sb.append(l+" ");
		System.out.println(sb.toString());
	}

}
