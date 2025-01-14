import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=0; tc<T; tc++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int N = Integer.parseInt(st.nextToken());
			List<Integer> arr = new ArrayList<Integer>();
			for(int i=0; i<N; i++) {
				arr.add(Integer.parseInt(st.nextToken()));
			}
			
			long sum = 0;
			for(int i=0; i<arr.size()-1; i++) {
				for(int j=i+1; j<arr.size(); j++) {
					sum += gcd(arr.get(i), arr.get(j));
				}
			}
			sb.append(sum+"\n");
		}
		System.out.println(sb.toString());
	}
	
	// 최대공약수 구하는 함수
	public static int gcd(int a, int b) {
		if( b == 0 ) return a;
		else return gcd(b, a%b);
	}

}
