import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int x = Integer.parseInt(br.readLine());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		int count = 0; 
		// 개수가 1개 일 땐, 조합이 불가능하므로 2개 이상일 때만 확인
		if( N > 1 ) {
			Arrays.sort(arr);		// 오름차순 정렬
			
			int l = 0, r = N-1;
			
			while( l < r ) {
				if( arr[l] + arr[r] == x ) {
					count++;
					r--;
				} else if( arr[l] + arr[r] > x ) {
					r--;
				} else {
					l++;
				}
			}
		}
		
		System.out.println(count);
	}

}
