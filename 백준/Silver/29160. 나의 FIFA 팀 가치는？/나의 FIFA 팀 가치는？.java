import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		
		List<PriorityQueue<Integer>> players = new ArrayList<PriorityQueue<Integer>>();
		int[] draft = new int[11];
		
		for(int i=0; i<11; i++) {
			players.add(new PriorityQueue<Integer>(Collections.reverseOrder()));
		}
		
		// 포지션 별 선수가치
		for(int i=0; i<N; i++) {
			StringTokenizer p = new StringTokenizer(br.readLine());
			
			int P = Integer.parseInt(p.nextToken()) - 1;
			int W = Integer.parseInt(p.nextToken());
			
			players.get(P).add(W);
		}
		
		// 첫 3월 : 선수 선발
		for(int i=0; i<11; i++) {
			if( !players.get(i).isEmpty() ) draft[i] = players.get(i).poll();
		}
		
		for(int i=0; i<K; i++) {
			for(int j=0; j<11; j++) {
				// 8월 : 선수가치 - 1
				if( draft[j] > 0 ) draft[j]--;

				// 11월 : 선발 선수 재구성
				// 같은 포지션에 후보선수가 존재하고, 현재 선발선수보다 가치가 높은 후보선수가 있다면 교체
				if( !players.get(j).isEmpty() && draft[j] < players.get(j).peek() ) {
					players.get(j).add(draft[j]);
					draft[j] = players.get(j).poll();
				}
			}
		}
		
		// K년 12월 선수가치의 
		int sum = 0;
		for(int i=0; i<11; i++) {
			sum += draft[i];
		}
		System.out.println(sum);
	}

}
