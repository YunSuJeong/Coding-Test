import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		int L = Integer.parseInt(br.readLine());
		
		int network[][] = new int[N+1][N+1];
		for(int i=0; i<L; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			network[a][b] = 1;
			network[b][a] = 1;
		}
		int arr[] = new int[N+1];
		for(int i=2; i<=N; i++) {
//			System.out.println("=========");
			if( network[1][i] > 0 ) arr = search(network, arr, 1, i, N);
		}
		
		int cnt = 0;
		for(int i=2; i<=N; i++) {
			if( arr[i] > 0 ) cnt++;
		}
		System.out.println(cnt);
	}
	
	public static int[] search(int[][] network, int[] arr, int a, int b, int n) {
//		System.out.println(a+" "+b);
//		for(int[] net : network) {
//			for(int num : net) System.out.print(num);
//			System.out.println();
//		}
		
		if( a > n || b > n ) return arr;
		else if( network[a][b] == 0 || network[a][b] == 2 ) return search(network, arr, a, b+1, n);
		else {
			arr[b] = 1;
			network[a][b] = 2;
			network[b][a] = 2;
			for(int i=2; i<=n; i++) {
				search(network, arr, b, 1, n);
			}
			return arr;
		}
	}

}
