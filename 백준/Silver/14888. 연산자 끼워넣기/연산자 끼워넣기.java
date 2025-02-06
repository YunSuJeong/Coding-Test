import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {
	
	public static int N = 0, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	public static int[] arr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		N = Integer.parseInt(br.readLine());
		StringTokenizer num = new StringTokenizer(br.readLine());
		StringTokenizer oper = new StringTokenizer(br.readLine());
		
		// 수와 연산자 입력받기
		arr = new int[N];
		int[] operator = new int[4];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(num.nextToken());
		}
		for(int i=0; i<4; i++) {
			operator[i] = Integer.parseInt(oper.nextToken());
		}
		
		calc(operator, 0, 0, 0);
		
		System.out.println(max);
		System.out.println(min);
	}
	
	public static void calc(int[] operator, int num, int idx, int level) {
			if( level >= N-1 ) {
				max = Math.max(max, num);
				min = Math.min(min, num);
				return;
			}
			
			for(int i=0; i<4; i++) {
				if( operator[i] > 0 ) {
					operator[i] -= 1;
					if( i == 0 ) 
						calc(operator, idx == 0 ? arr[idx]+arr[idx+1] : num + arr[idx+1], idx+1, level+1);
					else if( i == 1 ) 
						calc(operator, idx == 0 ? arr[idx]-arr[idx+1] : num - arr[idx+1], idx+1, level+1);
					else if( i == 2 )
						calc(operator, idx == 0 ? arr[idx]*arr[idx+1] : num * arr[idx+1], idx+1, level+1);
					else 
						calc(operator, idx == 0 ? arr[idx]/arr[idx+1] : num/arr[idx+1], idx+1, level+1);
					operator[i] += 1;
				}
			}
	}

}
