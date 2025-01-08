import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String word = br.readLine();
		
		int cnt[] = new int[26];		
		// a = 97
		for(int i=0; i<word.length(); i++) {
			cnt[word.charAt(i)-97] ++;
		}
		
		for(int n : cnt) {
			sb.append(n+" ");
		}
		System.out.println(sb.toString());
	}

}
