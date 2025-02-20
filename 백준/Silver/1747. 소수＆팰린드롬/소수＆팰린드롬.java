import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/*	소수&팰린드롬 */
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
		boolean isPalin = false;
		while( true ) {
			// 팰린드롬인지 판단
			// 1) 문자열로 확인
//			String pNum = Integer.toString(num);
//			for(int i=0; i<pNum.length()/2; i++) {
//				if( pNum.charAt(i) != pNum.charAt(pNum.length()-1-i) ) {
//					isPalin = false;
//					break;
//				}
//			}
			
			// 2) 사칙연산 이용하여 뒤부터 읽은 숫자 만들기
			int remain = num % 10;
			int tmp = num;
			while( true ) {
				if( tmp / 10 == 0 ) {
					break;
				}
				tmp /= 10;
				remain = remain * 10 + tmp % 10;
			}
			if( num == remain ) isPalin = true;
			
			// 팰린드롬이면 루프 탈출
			if( !arr[num] && isPalin ) break;
			
			num++;
			isPalin = false;
		}
		System.out.println(num);
	}

}
