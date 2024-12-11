import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int tall[] = new int[9];
		int sum = 0;
		
		for(int i=0; i<9; i++) {
			int t = Integer.parseInt(br.readLine());
			tall[i] = t;
			sum += t;
		}
		Arrays.sort(tall);
		
		// '9명 키의 합 - 2명의 키 합이 100인 것을 비교' = '7명의 키의 합이 100인 것을 비교'
		for(int i=0; i<8; i++) {
			for(int j=i+1; j<9; j++) {
				if( sum - tall[i] - tall[j] == 100 ) {
					tall[i] = 0;
					tall[j] = 0;
					break;
				}
			}
			// 이미 두명을 찾았다면 더 탐색하지 않음
			if( tall[i] == 0 ) break;
		}
		
		for(int t : tall) {
			if( t > 0 ) System.out.println(t);
		}
	}

}
