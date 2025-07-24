import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int k;
	public static int[] arr, lotto = new int[6];
	public static boolean[] visited;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while( (str=br.readLine()) != null ) {
			if( str.equals("0") ) break;
			
			StringTokenizer st = new StringTokenizer(str);
			
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			visited = new boolean[k];
			
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Arrays.sort(arr);
			
			for(int i=0; i<k; i++) {
				combination(0, i);
			}
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	// n : 현재 선택순서, idx : k개 숫자 중 선택된 인덱스
	public static void combination(int n, int idx) {
		visited[idx] = true;
		
		// 로또 번호 저장
		lotto[n] = arr[idx];
		
		if( n == 5 ) {
			for(int l : lotto) sb.append(l+" ");
			sb.append("\n");
			visited[idx] = false;
			return;
		}
		
		for(int i=idx+1; i<k; i++) {
			if( !visited[i] ) {
				combination(n+1, i);
			}
		}
		visited[idx] = false;
		
	}
}
