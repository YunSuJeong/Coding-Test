import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
	
	public static String pre = "", in = "", post = "";
	public static int[][] arr;
	public static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		arr = new int[N][2];
		
		for(int i=0; i<N; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int P = st.nextToken().charAt(0) - 65;
			int L = st.nextToken().charAt(0);
			int R = st.nextToken().charAt(0);
			
			arr[P][0] = L == '.' ? 0 : L-65;
			arr[P][1] = R == '.' ? 0 : R-65;
		}
		
		preOrder(0);
		sb.append("\n");
		
		inOrder(0);
		sb.append("\n");
		
		postOrder(0);
		System.out.println(sb.toString());
	}
	
	public static void preOrder(int n) {
		sb.append((char)(n+65));
		for(int i=0; i<2; i++) {
			if( arr[n][i] != 0 ) preOrder(arr[n][i]);
		}
	}
	
	public static void inOrder(int n) {
		if( arr[n][0] != 0 ) inOrder(arr[n][0]);
		sb.append((char)(n+65));
		if( arr[n][1] != 0 ) inOrder(arr[n][1]);
	}

	public static void postOrder(int n) {
		if( arr[n][0] != 0 ) postOrder(arr[n][0]);
		if( arr[n][1] != 0 ) postOrder(arr[n][1]);
		sb.append((char)(n+65));
	}

}
