import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			String arr[] = str.split(" ");
			
			sb.append("Case #"+(i+1)+": ");
			for(int j=arr.length-1; j>=0; j--) {
				sb.append(arr[j]+" ");
			}
			sb.append("\n");
		}
		System.out.println(sb.toString());
	}

}
