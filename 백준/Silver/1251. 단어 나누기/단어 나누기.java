import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		List<String> list = new ArrayList<String>();
		for(int i=1; i<str.length()-1; i++) {
			String w1 = str.substring(0, i);
			

			for(int j=i+1; j<str.length(); j++) {
				// 세 단어로 나누기
				String w2 = str.substring(i, j);
				String w3 = str.substring(j);
				
				// 각각 뒤집고 합치기
				StringBuilder sb = new StringBuilder();
				for(int k=w1.length()-1; k>=0; k--) {
					sb.append(w1.charAt(k));
				}
				for(int k=w2.length()-1; k>=0; k--) {
					sb.append(w2.charAt(k));
				}
				for(int k=w3.length()-1; k>=0; k--) {
					sb.append(w3.charAt(k));
				}
				
				list.add(sb.toString());
			}
		}
		
		Collections.sort(list);
		
		System.out.println(list.get(0));
	}

}
