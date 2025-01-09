import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			
		int N = Integer.parseInt(br.readLine());	
		
		int remain = 5;
		
		for(int i=2; i<=N; i++) {
			remain += (i*5 - (2*(i-1)+1)) % 45678;
			remain %= 45678;
		}
		System.out.println(remain);
	}

}
