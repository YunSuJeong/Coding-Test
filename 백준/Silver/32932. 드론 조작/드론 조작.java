import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());
		
		int[][] arr = new int[N][2];
		for(int i=0; i<N; i++) {
			StringTokenizer block = new StringTokenizer(br.readLine());
			
			int x = Integer.parseInt(block.nextToken());
			int y = Integer.parseInt(block.nextToken());
			
			arr[i][0] = x;
			arr[i][1] = y;
		}
		
		String str = br.readLine();
		int x = 0, y = 0;
		for(int i=0; i<K; i++) {
			int a = x, b = y;
			char cmd = str.charAt(i);
			switch (cmd) {
			case 'U':
				b++;
				break;
			case 'D':
				b--;
				break;
			case 'R':
				a++;
				break;
			case 'L':
				a--;
				break;
			}
			
			// 장애물 있는지 체크
			boolean flag = false;
			for(int j=0; j<N; j++) {
				if( arr[j][0] == a && arr[j][1] == b ) {
					flag = true;
					break;
				}
			}
			
			if( !flag ) {
				x = a;
				y = b;
			} 
		}
		System.out.println(x+" "+y);
	}

}
