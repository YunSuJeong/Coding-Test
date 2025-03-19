import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
	
	public static String[][] arr = new String[5][5];
	public static Set<String> set = new HashSet<String>();
	
	public static int[] X = {-1, 1, 0, 0};
	public static int[] Y = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int i=0; i<5; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			for(int j=0; j<5; j++) {
				arr[i][j] = st.nextToken();
			}
		}
		
		for(int i=0; i<5; i++) {
			for(int j=0; j<5; j++) {
				String[] num = new String[6];
				dfs(i, j, 0, num);
			}
		}
		
		System.out.println(set.size());
	}
	
	public static void dfs(int x, int y, int depth, String[] num) {
		num[depth] = arr[x][y];
		
		if( depth == 5 ) {
			add(num);
			return;
		}
		
		for(int i=0; i<4; i++) {
			int a = x + X[i];
			int b = y + Y[i];
			if( a >= 0 && a < 5 && b >= 0 && b < 5 ) dfs(a, b, depth+1, num);
		}
	}
	
	public static void add(String[] num) {
		StringBuilder sb = new StringBuilder();
		for(String s : num) {
			sb.append(s);
		}
		set.add(sb.toString());
	}
}
