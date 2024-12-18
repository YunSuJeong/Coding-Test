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
		
		int N = Integer.parseInt(br.readLine());
		String strN = br.readLine();
		StringTokenizer st1 = new StringTokenizer(strN);
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		for(int i=0; i<N; i++) {
			String num = st1.nextToken();
			if( !map.containsKey(num) ) map.put(num, 1);
			else map.put(num, map.get(num)+1);
		}
		
		int M = Integer.parseInt(br.readLine());
		String strM = br.readLine();
		StringTokenizer st2 = new StringTokenizer(strM);
		for(int i=0; i<M; i++) {
			String num = st2.nextToken();
			if( map.containsKey(num) ) bw.write(map.get(num)+" ");
			else bw.write(0+" ");
		}
		bw.flush();
		bw.close();
	}

}
