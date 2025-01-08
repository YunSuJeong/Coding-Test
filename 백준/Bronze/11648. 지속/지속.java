import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int num = Integer.parseInt(br.readLine());
		
		int cycle = 0;
		while(true) {
			
			if( num / 10 == 0 ) break;

			// 각 자리수 곱하기
			int multi = 1;
			while(true) {
				multi *= num%10;
				num /= 10;
				if( num == 0 ) break;
			}
			num = multi;
			cycle++;
		}
		
		System.out.println(cycle);
	}

}
