import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int A = Integer.parseInt(br.readLine());
		int B = Integer.parseInt(br.readLine());
		int C = Integer.parseInt(br.readLine());
		
		int multi = A * B * C;
		int arr[] = new int[10];
		for(int i=Integer.toString(multi).length()-1; i>=0; i--) {
			arr[multi/(int)Math.pow(10, i)] += 1;
			multi = multi % (int)Math.pow(10, i); 
		}
		
		for(int a : arr) {
			System.out.println(a);
		}
	}

}
