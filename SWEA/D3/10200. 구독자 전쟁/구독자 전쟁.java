import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			
			// 더 적은 답변의 질문에 답변한 모든 사람들이 중복답변한 경우 : 최대 중복 답변자 수
			// ex) A = 4, B = 5 일때, 최대는 A에 답변한 사람이 모두 B에 답변한 경우
			int max = Math.min(A, B);
			
			// 두 질문에 답변한 모든 인원 - N : 최소 중복 답변자 수
			int min = A + B - N;
			if( min < 0 ) min = 0;
			
			System.out.printf("#%d %d %d\n", tc, max, min);
		}
	}

}
