import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		
		String str = br.readLine();
		
		if( str.indexOf("0") >= 0 ) {
			int len = str.length();
			int arr[] = new int[len];
			
			int sum = 0;
			for(int i=0; i<len; i++) {
				arr[i] = str.charAt(i)-'0';
				sum += arr[i];
			}
			
			if( sum % 3 == 0 ) {
				Arrays.sort(arr);
				for(int i=len-1; i>=0; i--) System.out.print(arr[i]);
			} else {
				System.out.println(-1);
			}
			
			
		} else {
			System.out.println(-1);
		}
	}

}
