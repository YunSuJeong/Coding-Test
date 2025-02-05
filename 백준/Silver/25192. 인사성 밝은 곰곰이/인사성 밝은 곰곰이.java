import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		Set<String> nickName = new HashSet<String>();
		int cnt = 0;
		for(int i=0; i<N; i++) {
			String nick = br.readLine();
			if( nick.equals("ENTER") ) {
				cnt += nickName.size();
				nickName.clear();
			} else {
				nickName.add(nick);
			}
		}
		
		System.out.println(cnt+nickName.size());
	}

}