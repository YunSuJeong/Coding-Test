import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int T = Integer.parseInt(br.readLine());
		int	B = Integer.parseInt(br.readLine());
		
		int cycle = 1, currentNo = 0, cnt = 0;
		while( true ) {
			// 번, 데기, 번, 데기
			for(int i=0; i<4; i++) {
				if( B == 0 && i % 2 == 0) cnt++;
				if( B == 1 && i % 2 == 1) cnt++;
				if(cnt == T) {
					System.out.println(currentNo % A);
					return;
				}
				currentNo++;
			}
			
			// 번 * (cycle+1)
			for(int i=0; i<cycle+1; i++) {
				if( B == 0 ) cnt++;
				if(cnt == T) {
					System.out.println(currentNo % A);
					return;
				}
				currentNo++;
			}

			// 데기 * (cycle+1)
			for(int i=0; i<cycle+1; i++) {
				if( B == 1 ) cnt++;
				if(cnt == T) {
					System.out.println(currentNo % A);
					return;
				}
				currentNo++;
			}
			cycle++;
		}
	}

}
