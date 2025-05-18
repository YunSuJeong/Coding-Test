import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			List<ArrayList<Integer>> graph = new ArrayList<ArrayList<Integer>>();
			
			for(int i=0; i<=N; i++) {
				graph.add(new ArrayList<Integer>());
			}
			
			for(int i=0; i<M; i++) {
				StringTokenizer edge = new StringTokenizer(br.readLine());
				
				int n1 = Integer.parseInt(edge.nextToken());
				int n2 = Integer.parseInt(edge.nextToken());
				
				graph.get(n1).add(n2);
				graph.get(n2).add(n1);
			}
			
			int triangle = 0;
			for(int i=1; i<=N; i++) {
				for(int j : graph.get(i)) {
					for(int k : graph.get(j)) {
						if( i < j && j < k && graph.get(k).contains(i) ) triangle++;
					}
				}
			}
			System.out.printf("#%d %d\n", tc, triangle);
		}
		
	}

}
