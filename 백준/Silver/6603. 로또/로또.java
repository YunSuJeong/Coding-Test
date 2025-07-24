import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int k;
	public static int[] arr, lotto = new int[6];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		while( (str=br.readLine()) != null ) {
			if( str.equals("0") ) break;
			
			StringTokenizer st = new StringTokenizer(str);
			
			k = Integer.parseInt(st.nextToken());
			arr = new int[k];
			
			for(int i=0; i<k; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			combination(0, 0);
			
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

	// n : 현재 선택순서, idx : k개 숫자 중 선택된 인덱스
	public static void combination(int n, int idx) {
		if( n == 6 ) {
			for(int l : lotto) sb.append(l+" ");
			sb.append("\n");
			return;
		}
		
		for(int i=idx; i<k; i++) {
			// 로또 번호 저장
			lotto[n] = arr[i];
			combination(n+1, i+1);
		}
		
	}
}
