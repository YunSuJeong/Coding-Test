import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			int N = Integer.parseInt(br.readLine());
			
			int[] arr = new int[10];			// 각 숫자의 개수 
			
			int max = 0, min = 0, level = 0, num = N;
			while( true ) {
				if( num == 6174 ) break;

				Arrays.fill(arr, 0);
				for(int i=0; i<4; i++) {
					arr[num%10]++;
					num /= 10;
				}
				
				// 가장 큰 수 만들기
				max = makeMax(arr);
				
				// 가장 작은 수 만들기
				min = makeMin(arr);
				
				level++;
				num = max - min;
			}
			sb.append(level+"\n");
		}
		System.out.println(sb.toString());
	}

	public static int makeMax(int[] arr) {
		int num = 0;
		for(int i=9; i>=0; i--) {
			for (int j = 0; j < arr[i]; j++) {		// 각 숫자 개수만큼 반복
				num *= 10;
				num += i;
			}
		}
		return num;
	}
	
	public static int makeMin(int[] arr) {
		int num = 0;
		for(int i=0; i<10; i++) {
			for (int j = 0; j < arr[i]; j++) {		// 각 숫자 개수만큼 반복
				num *= 10;	
				num += i;
			}
		}
		return num;
	}
}
