import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		Queue<Integer> queue = new LinkedList<Integer>();
		int arr[] = new int[N];
		for(int i=1; i<=N; i++) {
			queue.offer(i);
		}
		
		int idx = 0;
		while( !queue.isEmpty() ) {
			for(int i=1; i<=K; i++) {
				if( i == K ) {
					arr[idx] = queue.poll();
					idx++;
				} else {
					queue.offer(queue.poll());
				}
			}
		}
		
		// 출력
		String result = Arrays.toString(arr).replace("[", "<").replace("]", ">");
		bw.write(result);
		bw.flush();
		bw.close();
	}

}
