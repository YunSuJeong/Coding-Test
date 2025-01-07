import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		int arr[] = new int[str.length()];
		
		for(int i=0; i<N-1; i++) {
			String s = br.readLine();

			for(int j=0; j<str.length(); j++) {
				if( arr[j] == 0 && str.charAt(j) != s.charAt(j) ) arr[j] += 1;
			}
		}
		
		for(int i=0; i<str.length(); i++) {
			if( arr[i] > 0 ) System.out.print("?");
			else System.out.print(str.charAt(i));
		}
	}

}
