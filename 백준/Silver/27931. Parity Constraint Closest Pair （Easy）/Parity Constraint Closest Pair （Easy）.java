import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		ArrayList<Integer> arrE = new ArrayList<Integer>();
		ArrayList<Integer> arrO = new ArrayList<Integer>();
		int[] arr = new int[N];
		for(int i=0; i<N; i++) {
			int num = Integer.parseInt(st.nextToken());
			arr[i] = num;
			if( num % 2 == 0 ) arrE.add(num);
			else arrO.add(num);
		}
		
		Collections.sort(arrE);
		Collections.sort(arrO);
		Arrays.sort(arr);
		
		int even = 2000000001;
		int odd = 2000000001;
		
		// 서로 다른 두 점의 거리 중 짝수인 최솟값
		// 짝짝만 비교
		for(int i=0; i<arrE.size()-1; i++) {
			even = Math.min(even, arrE.get(i+1)-arrE.get(i));
		}
		// 홀홀만 비교
		for(int i=0; i<arrO.size()-1; i++) {
			even = Math.min(even, arrO.get(i+1)-arrO.get(i));
		}
		
		// 서로 다른 두 점의 거리 중 홀수인 최솟값
		// 짝홀 or 홀짝
		for(int i=0; i<N-1; i++) {
			int diff = arr[i+1] - arr[i];
			if( diff % 2 == 1 ) odd = Math.min(odd, diff);
		}
		
		if( odd == 2000000001 ) odd = -1;
		if( even == 2000000001 ) even = -1;
		
		System.out.printf("%d %d", even, odd);
	}

}
