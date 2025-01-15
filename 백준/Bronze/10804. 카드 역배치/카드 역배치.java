import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int arr[] = new int[21];
		for(int i=0; i<=20; i++) {
			arr[i] = i;
		}
		
		for(int tc=0; tc<10; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			for(int i=0; i<20; i++) {
				if( i == a ) {
					for(int j=a; j<=(a+b)/2; j++) {
						int tmp = arr[j];
						arr[j] = arr[(a+b)-j];
						arr[(a+b)-j] = tmp;
					}
				}
			}
		}
		
		for(int a : arr) {
			if( a > 0 ) sb.append(a+" ");
		}
		System.out.println(sb.toString().trim());
	}

}
