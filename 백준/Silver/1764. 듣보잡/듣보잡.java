import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());
		
		Set<String> set = new HashSet<String>();
		for(int i=0; i<N; i++) {
			set.add(br.readLine());
		}
		
		int cnt = 0;
		List<String> list = new ArrayList<String>();
		for(int i=0; i<M; i++) {
			String name = br.readLine();
			if( set.contains(name) ) {
				cnt++;
				list.add(name);
			}
		}
		
		Collections.sort(list);			// 사전순으로 정렬

		// 출력
		bw.write(cnt+"\n");
		for(String name : list) {
			bw.write(name+"\n");
		}
		bw.flush();
		bw.close();
	}

}
