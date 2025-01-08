import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int C = Integer.parseInt(br.readLine());
		
		for(int i=0; i<C; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int N = Integer.parseInt(st.nextToken());
			int arr[] = new int[N];
			
			// 학생 성적 저장 및 평균 구하기
			int sum = 0;
			for(int j=0; j<N; j++) {
				int score = Integer.parseInt(st.nextToken());
				arr[j] = score;
				sum += score;
			}
			float avg = (float)(sum)/N;
			
			// 평균 넘는 학생 수 구하기
			int cnt = 0;
			for(int a : arr) {
				if( a > avg ) cnt++;
			}
			
			// 비율 구하기
			double rate = Math.round((cnt*1.0)/N*100*1000)/1000.0;
			sb.append(String.format("%.3f", rate)+"%\n");
		}
		System.out.println(sb.toString());
	}

}
