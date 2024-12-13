import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str1 = br.readLine();
		String str2 = br.readLine();
		
		StringTokenizer st1 = new StringTokenizer(str1);
		StringTokenizer st2 = new StringTokenizer(str2);
		
		int N = Integer.parseInt(st1.nextToken());
		int k = Integer.parseInt(st1.nextToken());
		
		int arrX[] = new int[N];
		for(int i=0; i<N; i++) {
			arrX[i] = Integer.parseInt(st2.nextToken());
		}
		
		// Bubble Sort
		for(int i=N-1; i>0; i--) {
			for(int j=0; j<i; j++) {
				if( arrX[j] > arrX[j+1] ) {
					int tmp = arrX[j];
					arrX[j] = arrX[j+1];
					arrX[j+1] = tmp;
				}
			}
		}
		
		System.out.println(arrX[N-k]);
	}

}
