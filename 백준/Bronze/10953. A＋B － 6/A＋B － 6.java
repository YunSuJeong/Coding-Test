import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			
			int A = Integer.parseInt(str.split(",")[0]); 
			int B = Integer.parseInt(str.split(",")[1]); 
			
			System.out.println(A+B);
		}
	}

}
