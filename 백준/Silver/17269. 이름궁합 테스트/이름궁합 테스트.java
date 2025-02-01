import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		StringTokenizer st2 = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st1.nextToken());
		int M = Integer.parseInt(st1.nextToken());
		
		int num[] = {3, 2, 1, 2, 4, 3, 1, 3, 1, 1, 3, 1, 3, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1};
		
		// 이름 세팅
		int arr[] = new int[N+M];
		String nmN = st2.nextToken();
		String nmM = st2.nextToken();
		
		int len = N <= M ? N : M;
		for(int i=0; i<len; i++) {
			arr[i*2] = num[nmN.charAt(i)-65];
		}
		for(int i=0; i<len; i++) {
			arr[i*2+1] = num[nmM.charAt(i)-65];
		}
		if( N != M ) {
			for(int i=0; i<Math.abs(N-M); i++) {
				if( N > M ) arr[len*2+i] = num[nmN.charAt(len+i)-65];
				else arr[len*2+i] = num[nmM.charAt(len+i)-65];
			}
		}
		
        // 궁합 계산
		for(int i=N+M-1; i>=2; i--) {
			for(int j=0; j<i; j++) {
				arr[j] = (arr[j] + arr[j+1]) % 10;
			}
		}
		
		if( arr[0] == 0 ) System.out.println(arr[1]+"%");
		else System.out.println(arr[0]+""+arr[1]+"%");
	}

}
