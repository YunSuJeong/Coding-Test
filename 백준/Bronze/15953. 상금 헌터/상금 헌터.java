import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int t=0; t<T; t++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			int prize1 = 0, prize2 = 0;
			
			// 1회 상금 구하기
			int arrA[][] = {{1, 500}, {3, 300}, {6, 200}, {10, 50}, {15, 30}, {21, 10}};
			if( a > 21 || a == 0 ) prize1 = 0;
			else {
				for(int i=0; i<6; i++) {
					if( a <= arrA[i][0] ) {
						prize1 = arrA[i][1];
						break;
					}
				}
			}
			
			// 2회 상금 구하기
			int arrB[][] = {{1, 512}, {3, 256}, {7, 128}, {15, 64}, {32, 32}};
			if( b > 31 || b == 0 ) prize2 = 0;
			else {
				for(int i=0; i<5; i++) {
					if( b <= arrB[i][0] ) {
						prize2 = arrB[i][1];
						break;
					}
				}
			}
			
			int sum = (prize1 + prize2)*10000;
			if( sum == 0 ) sum = 0;
			sb.append(sum+"\n");
		}
		System.out.println(sb.toString());
	}

}
