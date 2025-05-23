import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N, M;
	public static boolean arr[];
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		StringTokenizer st = new StringTokenizer(str);
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		arr = new boolean[N+1];
		
		combination(0, 0, new int[M+1]);
		System.out.println(sb.toString());
	}
	
	public static void combination(int depth, int n, int[] p) {
		arr[n] = true;
		p[depth] = n;

		if( depth == M ) {
			for(int i=1; i<=M; i++) {
				sb.append(p[i]+" ");
			}
			sb.append("\n");
			arr[n] = false;
			return;
		}

		if( n > N ) return;
		
		for(int i=1; i<=N; i++) {
			if( i != n && !arr[i] ) combination(depth+1, i, p);
		}
		
		arr[n] = false;
	}
	
}
