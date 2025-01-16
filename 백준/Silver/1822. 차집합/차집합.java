import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		StringTokenizer stA = new StringTokenizer(br.readLine());
		StringTokenizer stB = new StringTokenizer(br.readLine());
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		int arrA[] = new int[A];
		int arrB[] = new int[B];

		for(int i=0; i<A; i++) {
			arrA[i] = Integer.parseInt(stA.nextToken());
		}
		
		for(int i=0; i<B; i++) {
			arrB[i] = Integer.parseInt(stB.nextToken());
		}
		Arrays.sort(arrB);
		
		// 이진탐색으로 A의 원소가 B에 속하지 않는지 확인
		List<Integer> list = new ArrayList<Integer>();
		for(int i=0; i<A; i++) {
			int mid = 0, low = 0, high = B-1;
			while( true ) {
				mid = (low+high)/2;
				
				if( low > high ) {
					mid = -1;
					break;
				}
				
				if( arrA[i] == arrB[mid] ) break;
				
				if( arrA[i] < arrB[mid] ) high = mid - 1;
				else low = mid + 1;
			}
			if( mid < 0 ) list.add(arrA[i]);
		}
		System.out.println(list.size());
		Collections.sort(list);
		if( list.size() > 0 ) {
			for(int a : list) {
				sb.append(a+" ");
			}
			System.out.println(sb.toString().trim());
		}
	}

}
