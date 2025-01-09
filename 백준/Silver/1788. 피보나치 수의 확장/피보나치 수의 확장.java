import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int n = Integer.parseInt(br.readLine());
		
		int num = Math.abs(n);
		int arr[] = new int[num+1];
		
		for(int i=0; i<=num; i++) {
			if( i <= 1 ) arr[i] = i;
			else {
				arr[i] = (arr[i-2]+arr[i-1])%1000000000;
			}
		}
		
		int sign = 0;
		if( n < 0 ) { 
			if( num % 2 == 0 ) sign = -1;
			else sign = 1;
		} else if( n > 0 ) sign = 1;
		
		System.out.println(sign);
		System.out.println(arr[num]);
	}

}
