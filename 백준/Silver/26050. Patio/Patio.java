import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int side = 3, window = 9, cnt = 0;
		while( window <= N ) {
			int inside = (side-2)*(side-2);
			int border = window - inside;
			
			// 초기 윈도우
			int red = 0, blue = 0;
			for(int i=0; i<window; i++) {
				if( str.charAt(i) == 'X' ) blue++;
				else red++;
			}
			if( (red == inside && blue == border) || (red == border && blue == inside) ) cnt++;
			
			for(int i=0; i<N-window; i++) {
				char remove = str.charAt(i);
				char add = str.charAt(i+window);
				
				if( remove == 'X' ) blue--;
				else red--;
				
				if( add == 'X' ) blue++;
				else red++;
				
				if( (red == inside && blue == border) || (red == border && blue == inside) ) cnt++;
			}
			
			side++;
			window = side * side;
		}
		System.out.println(cnt);
	}

}
