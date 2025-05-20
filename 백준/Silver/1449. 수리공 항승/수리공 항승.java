import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int L = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		StringTokenizer tape = new StringTokenizer(br.readLine());
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(tape.nextToken());
		}
		
		Arrays.sort(arr);
		
		// d : 현재 파이프까지 필요한 테이프 길이
		int d = 1, cnt = 0;
		for(int i=1; i<N; i++) {
			// 현재 파이프까지 필요한 테이프 길이 = 이전까지 필요한 테이프 길이 + (현재 파이프 위치 - 이전 파이프 위치)
			if( arr[i] - arr[i-1] + d <= L ) {
				d += arr[i] - arr[i-1];
			} else {
				d = 1;
				cnt++;
			}
		}
		if( d <= L ) cnt++;
		System.out.println(cnt);
	}

}
