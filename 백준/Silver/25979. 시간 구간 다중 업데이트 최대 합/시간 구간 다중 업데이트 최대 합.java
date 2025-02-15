import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 유형 1 처리
		int[] arr = new int[86400];
		for(int i=0; i<N-1; i++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			
			int type1 = Integer.parseInt(st1.nextToken());
			String[] time1 = st1.nextToken().split(":");
			String[] time2 = st1.nextToken().split(":");
			
			
			int h1 = Integer.parseInt(time1[0])*3600, m1 = Integer.parseInt(time1[1])*60, s1 = Integer.parseInt(time1[2]);
			int h2 = Integer.parseInt(time2[0])*3600, m2 = Integer.parseInt(time2[1])*60, s2 = Integer.parseInt(time2[2]);
			
			int start = h1 + m1 + s1;
			int end = h2 + m2 + s2;
			
			// 1. 시간 초과,,
//			for(int j=start+1; j<=end; j++) {
//				arr[j] += 1;
//			}
			
			// 2. 차이배열 + 누적합 이용 
			arr[start+1] += 1;
			if( end + 1 < 86400 ) arr[end+1] -= 1;
		}
		
		for(int i=1; i<86400; i++) {
			arr[i] += arr[i-1];
		}
		
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		int type2 = Integer.parseInt(st2.nextToken());
		String[] time = st2.nextToken().split(":");
		
		int interval = Integer.parseInt(time[0])*3600 +  Integer.parseInt(time[1]) * 60 + Integer.parseInt(time[2]);
		
		// 초기 윈도우
		long window = 0;
		for(int i=0; i<interval; i++) {
			window += arr[i];
		}
		long max = window;
		
		// 구간 합이 최대인 시간 구간의 구간 합 
		for(int i=0; i<86400-interval; i++) {
			window = window - arr[i] + arr[i+interval];
			max = Math.max(max, window);
		}
		System.out.println(max);
	}

}
