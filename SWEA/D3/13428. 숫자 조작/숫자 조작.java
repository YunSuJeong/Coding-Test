import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			String N = br.readLine();
			
			int len = N.length();
			char[] arr = new char[len];
			for(int i=0; i<len; i++) {
				arr[i] = N.charAt(i);
			}
			
			List<String> list = new ArrayList<String>();
			list.add(N);
			for(int i=0; i<len; i++) {
				for(int j=i+1; j<len; j++) {
					if( arr[j] != '0' || i != 0 ) {
						// 자리 변경
						char tmp = arr[j];
						arr[j] = arr[i];
						arr[i] = tmp;
						
						for(int k=0; k<len; k++) {
							sb.append(arr[k]);
						}
						list.add(sb.toString());
						sb.setLength(0);
						
						// 자리 원복
						arr[i] = arr[j];
						arr[j] = tmp;
					}
				}
			}
			
			Collections.sort(list);
			System.out.printf("#%d %s %s\n", tc, list.get(0), list.get(list.size()-1));
		}
	}

}
