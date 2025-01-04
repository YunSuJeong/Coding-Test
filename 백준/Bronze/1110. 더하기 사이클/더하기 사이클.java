import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws  IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int cycle = 1, num = N;
		
		if( num < 10 ) num = N * 10;
		while( true ) {
			
			// 각 자리수의 합
			int sum = num/10 + num%10;
			
			// 새로운 수
			int newN = (cycle == 1 && N < 10 ? N : (num%10))*10 + sum%10;
			
			if( N == newN ) break;
			cycle++;
			num = newN;
			
		}
		
		System.out.println(cycle);
	}

}
