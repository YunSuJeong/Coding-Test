import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		// 1) Arrays.sort or ArraysList라면 Collections.sort
//		int arr[] = new int[N];
//		for(int i=0; i<N; i++) {
//			arr[i] = Integer.parseInt(br.readLine());
//		}
//		
//		Arrays.sort(arr);
//		for(int n : arr) {
//			System.out.println(n);
//		}
		
		// 2) -1,000,000 ~ 1,000,000 숫자를 인덱스로 생각하고 배열에 저장
		boolean sort[] = new boolean[2000001];	
		
		for(int i=0; i<N; i++) {
			sort[Integer.parseInt(br.readLine())+1000000] = true;
		}
		
		for(int i=0; i<2000001; i++) {
			if( sort[i] ) System.out.println(i-1000000);
		}
		
	}

}
