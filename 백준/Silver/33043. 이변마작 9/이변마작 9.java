import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		String[] arr = new String[N];
		for(int i=0; i<N; i++) {
			String m = st.nextToken();
			arr[i] = m;
		}
		
		int window = N+2;
		int left = 0, right = 4;
		Map<String, Integer> map = new HashMap<String, Integer>();
		if( N < 5 ) 
			System.out.println(-1);
		else {
			for(int i=0; i<5; i++) {
				map.put(arr[i], map.getOrDefault(arr[i], 0)+1);
			}
			while( left < right ) {
//			System.out.println(left+" "+right);
//			System.out.println(map.toString());
				// 5개되는지 체크
				boolean flag = false;
				for( int n : map.values() ) {
					if( n >= 5 ) {
						flag = true;
						break;
					}
				}
				
				if( !flag ) {
					right++;
					if( right >= N ) break;
					map.put(arr[right], map.getOrDefault(arr[right], 0)+1);
				} else {
					map.put(arr[left], map.getOrDefault(arr[left], 0)-1);
					window = Math.min(window, right-left+1);
					left++;
				}
			}
			if( window > N ) System.out.println(-1);
			else System.out.println(window);
		}
		
	}

}
