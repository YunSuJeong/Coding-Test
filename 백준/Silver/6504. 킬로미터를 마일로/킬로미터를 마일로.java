import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int t = Integer.parseInt(br.readLine());
		
		// 25000보다 작은 피보나치 수열 구하기
		int fibo[] = new int[23];
		for(int i=0; i<23; i++) {
			if( i < 3 ) fibo[i] = i;
			else fibo[i] = fibo[i-1] + fibo[i-2];
		}
		
		for(int tc=0; tc<t; tc++) {
			int x = Integer.parseInt(br.readLine());
			
			// 피보나치 진법으로 변환
			List<Integer> list = new ArrayList<Integer>();
			for(int i=22; i>=1; i--) {
				if( x >= fibo[i] ) {
					x -= fibo[i];
					list.add(0, 1);
				} else {
					list.add(0, 0);
				}
			}
			
			int mile = 0;
			for(int i=1; i<list.size(); i++) {
				mile += list.get(i) * fibo[i];
			}
			System.out.println(mile);
		}
	}

}
