import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int N1 = Integer.parseInt(st.nextToken());
		int N2 = Integer.parseInt(st.nextToken());
		
		String A1 = br.readLine();
		String A2 = br.readLine();
		
		int T = Integer.parseInt(br.readLine());
		
		int arr[] = new int[N1+N2];
		char ants[] = new char[N1+N2];
		
		for(int i=0; i<N1; i++) {
			arr[i] = 1;
			ants[i] = A1.charAt(N1-i-1);
		}
		
		for(int i=N1; i<N1+N2; i++) {
			arr[i] = 2;
			ants[i] = A2.charAt(i-N1);
		}
		
		for(int i=0; i<T; i++) {
			for(int j=0; j<ants.length-1; ) {
				if( arr[j] == 1 && arr[j] != arr[j+1] ) {
					char tmp = ants[j];
					ants[j] = ants[j+1];
					ants[j+1] = tmp;
					
					int tmpArr = arr[j];
					arr[j] = arr[j+1];
					arr[j+1] = tmpArr;
					j+=2;
				} else {
					j++;
				}
			}
		}
		
		for(char a : ants) {
			sb.append(a);
		}
		System.out.println(sb.toString());
	}

}
