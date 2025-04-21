import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		List<ArrayList<Integer>> player = new ArrayList<ArrayList<Integer>>();
		for(int i=0; i<N; i++) {
			player.add(new ArrayList<Integer>());
		}
		
		for(int i=0; i<N; i++) {
			StringTokenizer card = new StringTokenizer(br.readLine());
			
			for(int j=0; j<M; j++) {
				player.get(i).add(Integer.parseInt(card.nextToken()));
			}
		}
		
		// 정렬
		for(int i=0; i<N; i++) {
			Collections.sort(player.get(i), Collections.reverseOrder());
		}
		
		// M번 경기 진행
		int[] score = new int[N];
		for(int i=0; i<M; i++) {
			int max = 0;
			for(int j=0; j<N; j++) {
				max = Math.max(max, player.get(j).get(i));
			}

			for(int j=0; j<N; j++) {
				if( max == player.get(j).get(i) ) score[j]++;
			}
		}
		
		int maxScore = 0;
		for(int s : score) {
			maxScore = Math.max(maxScore, s);
		}
		
		for(int i=0; i<N; i++) {
			if( score[i] == maxScore ) sb.append((i+1)+" ");
		}
		System.out.println(sb.toString());
	}

}
