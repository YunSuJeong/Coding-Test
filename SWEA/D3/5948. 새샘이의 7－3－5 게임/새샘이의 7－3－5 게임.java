import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[7];
			for(int i=0; i<7; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			Set<Integer> set = new HashSet<Integer>();
			for(int i=0; i<7; i++) {
				for(int j=i+1; j<7; j++) {
					for(int k=j+1; k<7; k++) {
						set.add(arr[i]+arr[j]+arr[k]);
					}
				}
			}
			
			List<Integer> list = new ArrayList<Integer>(set);
			
			Collections.sort(list);
			System.out.printf("#%d %d\n", tc, list.get(list.size()-5));
		}
	}

}
