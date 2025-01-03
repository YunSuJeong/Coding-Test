import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		String str = br.readLine();
		int len = str.length();
		
		int quot = len/10;
		int remain = len%10;
		
		for(int i=0; i<quot; i++) {
			sb.append(str.substring(10*i, 10*(i+1))+"\n");
		}
		
		if( remain > 0 ) sb.append(str.substring(10*quot));
		
		System.out.println(sb.toString());
		
	}

}
