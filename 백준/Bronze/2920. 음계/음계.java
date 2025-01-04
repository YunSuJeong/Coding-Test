import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		String arr[] = str.split(" ");
		
		int tmp = Integer.parseInt(arr[0]);
		int cnt = 0;
		String result = "";
		for(int i=1; i<8; i++) {
			if( tmp < Integer.parseInt(arr[i]) ) {
				cnt++;
			} 
			tmp = Integer.parseInt(arr[i]);
		}

		if( cnt == 7 ) result = "ascending";
		else if( cnt == 0 ) result = "descending";
		else result = "mixed";
		System.out.println(result);
	}

}
