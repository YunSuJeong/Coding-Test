import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			int n = Integer.parseInt(br.readLine());
			boolean room[] = new boolean[n];
			
			for(int j=0; j<n; j++) {
				for(int k=j; k<n; k+=j+1) {
					if( room[k] ) {
						// 열려있으면 닫는다.
						room[k] = false;
					} else {
						// 닫혀있으면 연다.
						room[k] = true;
					}
				}
			}
			
			int cnt = 0;
			for(boolean r : room) {
				if( r ) cnt++;
			}
			System.out.println(cnt);
			
		}
	}

}
