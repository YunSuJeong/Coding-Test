import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int K = Integer.parseInt(br.readLine());
		
		for(int i=0; i<K; i++) {
			int h = Integer.parseInt(br.readLine());
			String str = br.readLine();
			
			for(String s : str.split("")) {
				if( s.equals("c") ) h++;
				else h--;
			}
			
			sb.append("Data Set "+(i+1)+":\n");
			sb.append(h+"\n\n");
		}
		System.out.println(sb.toString());
	}
}
