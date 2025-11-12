import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		for(int tc=1; tc<=10; tc++) {
			StringTokenizer st1 = new StringTokenizer(br.readLine());
			StringTokenizer st2 = new StringTokenizer(br.readLine());
			
			int n = Integer.parseInt(st1.nextToken());
			int cnt = Integer.parseInt(st1.nextToken());
			
            // 경로 저장
			List<List<Integer>> list = new ArrayList<List<Integer>>();
			for(int i=0; i<100; i++) list.add(new ArrayList<Integer>());
			
			for(int i=0; i<cnt; i++) {
				int s = Integer.parseInt(st2.nextToken());
				int e = Integer.parseInt(st2.nextToken());
				
				list.get(s).add(e);
			}
			
            // 각 정점에 도달할 수 있는지 확인
			int isReach[] = new int[100];
			for(int i=0; i<100; i++) {
				if( list.get(i).size() > 0 ) {
					if( i == 0 ) isReach[i] = 1;
					for(int j : list.get(i)) {
						if( isReach[i] > 0 ) isReach[j] = 1;
					}
				} else {
					if( i == 0 ) break;
				}
			}
			
			System.out.printf("#%d %d\n", n, isReach[99]);
		}
	}

}
