import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("red", 0);
		map.put("orange", 1);
		map.put("yellow", 2);
		map.put("green", 3);
		map.put("blue", 4);
		map.put("purple", 5);
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			String color1 = st.nextToken();
			String color2 = st.nextToken();
			
			int i1 = map.get(color1);
			int i2 = map.get(color2);
			
			String result = "X";
			if( i1 == i2 ) {
				result = "E";
			} else if( (i1+5)%6 == i2 || (i1+7)%6 == i2 ) {
				result = "A";
			} else if( (i1+3)%6 == i2 ) {
				result = "C";
			}
			System.out.printf("%s\n", result);
		}
	}

}
