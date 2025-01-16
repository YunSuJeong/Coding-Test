import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int M = Integer.parseInt(br.readLine());
		
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<M; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String cmd = st.nextToken();
			int num;
			switch (cmd) {
			case "add":
				set.add(Integer.parseInt(st.nextToken()));
				break;
			case "remove":
				set.remove(Integer.parseInt(st.nextToken()));
				break;
			case "check":
				num = Integer.parseInt(st.nextToken());
				sb.append(set.contains(num) ? 1 : 0);
				sb.append("\n");
				break;
			case "toggle":
				num = Integer.parseInt(st.nextToken());
				if( set.contains(num) ) set.remove(num);
				else set.add(num);
				break;
			case "all":
				for(int j=1; j<=20; j++) {
					set.add(j);
				}
				break;
			case "empty":
				set.clear();
				break;
			default:
				break;
			}
		}
		System.out.println(sb.toString());
	}
}