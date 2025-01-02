import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			
			int cnt = 0;
			for(int x=1; x<=a; x++) {
				for(int y=1; y<=b; y++) {
					int r1 = x % y;
					for(int z=1; z<=c; z++) {
						int r2 = y % z;
						int r3 = z % x;
						if( r1 == r2 && r2 == r3 && r3 == r1 ) cnt++;
					}
				}
			}
			
			System.out.println(cnt);
		}
	}

}
