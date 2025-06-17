import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
	
	public static int K;
	public static int[] arr;
	public static List<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			list.add(new ArrayList<Integer>());
		}
		
		int len = (int) (Math.pow(2, K)-1);
		arr = new int[len];
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		for(int i=0; i<len; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		tree(0, len, 0);
		
		for(ArrayList<Integer> l : list) {
			for(int c : l) {
				sb.append(c+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}
	
	public static void tree(int s, int e, int level) {
		if( level == K ) return;
		
		int m = (s + e) / 2;
		list.get(level).add(arr[m]);
		
		tree(s, m, level+1);			// left subTree
		tree(m, e, level+1);			// right subTree
	}

}
