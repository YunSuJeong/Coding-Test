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
		int d = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());
		int c = Integer.parseInt(st.nextToken()) - 1;
		
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(br.readLine()) - 1;
		}
		
		int cnt = 0, max = 0;				// 연속된 k개 접시의 초밥 가짓 수
		int[] type = new int[d];			// 초밥 가짓 수
		for(int i=0; i<k; i++) {
			if( type[arr[i]] == 0 ) cnt++;
			type[arr[i]]++;
		}
		if( type[c] == 0 ) {
			max = cnt + 1;
		}
		
		for(int i=0; i<N; i++) {
			type[arr[i]]--;
			if( type[arr[i]] == 0 ) cnt--;
			if( type[arr[(i+k)%N]] == 0) cnt++;
			type[arr[(i+k)%N]]++;
			
			max = Math.max(max, type[c] == 0 ? cnt+1 : cnt);
		}
		System.out.println(max);
	}

}
