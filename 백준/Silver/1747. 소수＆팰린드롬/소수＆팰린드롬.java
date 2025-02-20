import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		boolean[] arr = new boolean[1003002];
		arr[1] = true;
		for(int i=2; i*i<=1003001; i++) {
			for(int j=i*i; j<=1003001; j+=i) {
				if( !arr[j] ) arr[j] = true;
			}
		}
		int num = N;
		boolean isPalin = true;
		while( true ) {
			// 팰린드롬인지 판단
			String pNum = Integer.toString(num);
			for(int i=0; i<pNum.length()/2; i++) {
				if( pNum.charAt(i) != pNum.charAt(pNum.length()-1-i) ) {
					isPalin = false;
					break;
				}
			}
			
			// 팰린드롬이면 루프 탈출
			if( !arr[num] && isPalin ) break;
			
			num++;
			isPalin = true;
		}
		System.out.println(num);
	}

}
