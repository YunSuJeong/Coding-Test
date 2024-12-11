import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int sum = 0;
		int len = Integer.toString(N).length();
		// 1자리수 1~9 : 9개, 2자리수 10~99 : 90개, 3자리수 100~999 : 900개		... 8자리 ... 9자리 : 1개
		// 자릿수 = 9*1 + 90*2 + 900*3 ... 
		for(int i=0; i<len-1; i++) {
			sum += (int)Math.pow(10, i)*9*(i+1);
		}
		sum += (N - (int)Math.pow(10, len-1) + 1)*len;
		
		
		System.out.println(sum);
	}

}
