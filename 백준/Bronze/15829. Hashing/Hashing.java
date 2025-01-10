import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int L = Integer.parseInt(br.readLine());
		String str = br.readLine();
		
		int r = 31;
		int M = 1234567891;
		
		int arrA[] = new int[L];
		long arrR[] = new long[L];			// 31의 제곱수들을 r로 나눈 나머지
		
		arrA[0] = (str.charAt(0)-96)%M;
		arrR[0] = 1;
		
		long sum = (arrA[0]*arrR[0])%M;
		for(int i=1; i<L; i++) {
			int n = str.charAt(i)-96;
			
			if( i == 1 ) arrR[i] = r;
			else arrR[i] = (arrR[i-1] * r%M) % M;
			
			sum += (n%M * arrR[i]) % M;
		}
		System.out.println(sum%M);
	}

}
