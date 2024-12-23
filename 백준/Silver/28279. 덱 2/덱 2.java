import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Deque;
import java.util.LinkedList;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		Deque<Integer> deque = new LinkedList<Integer>();
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int cmd = Integer.parseInt(st.nextToken());
			
			switch (cmd) {
			case 1:
				deque.offerFirst(Integer.parseInt(st.nextToken()));
				break;
			case 2:
				deque.offerLast(Integer.parseInt(st.nextToken()));
				break;
			case 3:
				bw.write( deque.isEmpty() ? -1+"\n" : deque.pollFirst()+"\n" );
				break;
			case 4:
				bw.write( deque.isEmpty() ? -1+"\n" : deque.pollLast()+"\n" );
				break;
			case 5:
				bw.write(deque.size()+"\n");
				break;
			case 6:
				bw.write( deque.isEmpty() ? 1+"\n" : 0+"\n" );
				break;
			case 7:
				bw.write( deque.isEmpty() ? -1+"\n" : deque.peekFirst()+"\n" );
				break;
			case 8:
				bw.write( deque.isEmpty() ? -1+"\n" : deque.peekLast()+"\n" );
				break;
			default:
				break;
			}
		}
		bw.flush();
		bw.close();
	}

}
