import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		String arr[][] = new String[N][2];
		
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			StringTokenizer st = new StringTokenizer(str);
			
			arr[i][0] = st.nextToken();
			arr[i][1] = st.nextToken();
		}
		
		Arrays.sort(arr, new Comparator<String[]>() {

			@Override
			public int compare(String[] o1, String[] o2) {
				int age1 = Integer.parseInt(o1[0]);
				int age2 = Integer.parseInt(o2[0]);
				return age1 - age2;
			}
		});
		
		for(String[] s : arr) {
			System.out.println(s[0]+" "+s[1]);
		}
	}

}
