import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static StringBuilder sb = new StringBuilder();
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		int X = Integer.parseInt(br.readLine());
		
		arr = new int[N];
		for(int i=0; i<N; i++) {
			int A = Integer.parseInt(st.nextToken());
			if( A == -1 ) A = X;
			
			arr[i] = A;
		}
		
		Arrays.sort(arr);
		
		postOrder(0, N);
		
		System.out.println(sb.toString());
	}
	
	public static void postOrder(int s, int len) {
		if( len == 1 ) {
			sb.append(arr[s]+" ");
			return;
		}
		
		postOrder(s, len/2);			// 왼쪽 트리
		postOrder(s+len/2+1, len/2);		// 오른쪽 트리
		
		sb.append(arr[s+len/2]+" ");				// 부모 노드
	}
}
