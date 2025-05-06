import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		for(int tc=1; tc<=10; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer nums = new StringTokenizer(br.readLine());
			
			List<Integer> list = new ArrayList<Integer>();
			for(int i=0; i<N; i++) {
				list.add(Integer.parseInt(nums.nextToken()));
			}
			
			int M = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			for(int i=0; i<M; i++) {
				String cmd = st.nextToken();
				if( cmd.equals("I") ) {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y; j++) {
						int s = Integer.parseInt(st.nextToken());
						list.add(x+j, s);
					}
				} else {
					int x = Integer.parseInt(st.nextToken());
					int y = Integer.parseInt(st.nextToken());
					for(int j=0; j<y; j++) {
						list.remove(x);
					} 
				}
			}
			
			for(int i=0; i<10; i++) {
				sb.append(list.get(i)+" ");
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
