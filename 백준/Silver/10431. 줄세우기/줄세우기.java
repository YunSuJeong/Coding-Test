import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int P = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=P; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int T = Integer.parseInt(st.nextToken());
			int[] arr = new int[20];
			for(int i=0; i<20; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			List<Integer> line = new ArrayList<Integer>();
			line.add(arr[0]);

			int cnt = 0;
			for(int i=1; i<20; i++) {
				for(int j=0; j<i; j++) {
					if( arr[i] < line.get(j) ) {
						line.add(j, arr[i]);
						cnt += (i - j);
						break;
					} else {
						line.add(i, arr[i]);
					}
				}
			}
			sb.append(T+" "+cnt+"\n");
		}
		System.out.println(sb.toString());
	}

}
