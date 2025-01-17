import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Map<String, String> map = new HashMap<String, String>();
		for(int i=0; i<N; i++) {
			StringTokenizer str = new StringTokenizer(br.readLine());
			map.put(str.nextToken(), str.nextToken());
		}
		
		for(int i=0; i<M; i++) {
			bw.write(map.get(br.readLine())+"\n");
		}
		bw.flush();
		bw.close();
	}

}
