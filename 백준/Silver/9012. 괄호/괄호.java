import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			
			String result = "NO\n";
			if( str.length() % 2 == 0 ) {
				int cnt = 0;
				for(String s : str.split("")) {
					if( s.equals("(") ) cnt++;
					else cnt--;
					
					if( cnt < 0 ) break;
				}
				if( cnt == 0 ) result = "YES\n";
			}
			 bw.write(result);
		}
		
		bw.flush();
		bw.close();
	}

}
