import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int n=0; n<T; n++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			String strN = br.readLine();
			StringTokenizer stN = new StringTokenizer(strN);
			
			int N = Integer.parseInt(st.nextToken());
			int M = Integer.parseInt(st.nextToken());
			
			Queue<int[]> queue = new LinkedList<>();
			for(int i=0; i<N; i++) {
				int num = Integer.parseInt(stN.nextToken());
				queue.add(new int[] {i, num});
			}
			
			int cnt = 0;
			while( !queue.isEmpty() ) {
				int arr[] = queue.poll();
				boolean flag = true;
				for(int[] el : queue) {
					if( el[1] > arr[1] ) {
						queue.offer(arr);
						flag = false;
						break;
					}
				}
				
				if(flag) { 
					cnt++;
					if( arr[0] == M ) break;
				}
			}
			System.out.println(cnt);
		}
	}
}

