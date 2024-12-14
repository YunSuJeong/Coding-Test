import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		int count[] = new int[10001];
		for(int i=0; i<N; i++) {
			count[Integer.parseInt(br.readLine())] += 1;
		}
		
		for(int i=0; i<10001; i++) {
			while( count[i] > 0 ) {
				bw.write(i+"\n");
				count[i] -= 1;
			} 
		}
		bw.flush();
		bw.close();
		
	}

}
