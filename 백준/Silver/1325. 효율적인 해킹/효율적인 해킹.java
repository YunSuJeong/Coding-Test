import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static int N, M, count = 0;
	public static List<ArrayList<Integer>> pc = new ArrayList<ArrayList<Integer>>();
	public static boolean visited[];
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		for(int i=0; i<N; i++) {
			pc.add(new ArrayList<Integer>());
		}
		
		// 신뢰 관계(양방향) 저장
		for(int i=0; i<M; i++) {
			StringTokenizer trust = new StringTokenizer(br.readLine());
			
			int A = Integer.parseInt(trust.nextToken()) - 1;
			int B = Integer.parseInt(trust.nextToken()) - 1;
			
			pc.get(B).add(A);
		}
		
		int max = 0;
		int[] hacking = new int[N];
		visited = new boolean[N];
		for(int i=0; i<N; i++) {
			Arrays.fill(visited, false);		// 방문 초기화
			count = 0;
			hacking[i] = dfs(i);
			max = Math.max(max, hacking[i]);
		}
		
		for(int i=0; i<N; i++) {
			if( hacking[i] == max ) sb.append((i+1)+" ");
		}
		System.out.println(sb.toString());
	}

	public static int dfs(int n) {
		visited[n] = true;
		
		boolean flag = false;		// 탐색 가능한 신뢰관계가 존재하는지
		for(int i : pc.get(n ) ) {
			if( !visited[i] ) {
				flag = true;
				break;
			}
		}
		if( !flag ) return count;
		
		for(int i : pc.get(n)) {
			if( !visited[i] ) {
				count++;
				dfs(i);
			}
		}
		return count;
	}
}
