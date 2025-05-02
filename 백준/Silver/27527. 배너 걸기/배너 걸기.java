import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer A = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(A.nextToken());
		}
		
		int num = M * 9 / 10;
		if( M * 9 % 10 > 0 ) num++;
		
		int[] cnt = new int[1000001];
		
		// 초기 윈도우 세팅
		boolean flag = false;
		for(int i=0; i<M; i++) {
			cnt[arr[i]]++;
			
			if( cnt[arr[i]] >= num ) flag = true;
		}
		
		if( !flag ) {
			for(int i=0; i<N-M; i++) {
				int prev = arr[i];
				int next = arr[i+M];
				
				cnt[prev]--;			// 맵 앞을 제외시키고
				cnt[next]++;			// 다음 한 칸을 포함시켜 윈도우 크기 유지
				
				if( cnt[next] >= num ) {
					flag = true;
					break;
				}
			}
		}
		System.out.println(flag ? "YES" : "NO");
	}

}
