import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {
	
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		
		String str = "";
		while( (str=br.readLine()) != null ) {
			int N = Integer.parseInt(str);
			
			int len = (int) Math.pow(3, N);
			arr = new int[len];
			
			for(int i=0; i<len; i++) {
				arr[i] = 1;
			}
			cantor(0, len, len);
			
			for(int n : arr) {
				if( n == 1 ) sb.append("-");
				else sb.append(" ");
			}
			System.out.println(sb.toString());
			sb.setLength(0);
		}
	}
	
	public static void cantor(int start, int end, int len) {
		if( len == 0 ) return;
		
		// 중간 부분 0으로 변경
		for(int i=start+len/3; i<start+(len/3)*2; i++) {
			arr[i] = 0;
		}
			
		// 좌우 부분 재귀
		cantor(start, start+len/3, len/3);
		cantor(end-len/3, end, len/3);
	}

}
