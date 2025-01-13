import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		for(int n=0; n<N; n++) {
			String str = br.readLine();
			
			List<Integer> list = new ArrayList<Integer>();
			for( String s : str.split(" ") ) list.add(Integer.parseInt(s));
			
			int max = 1;
			for(int i=0; i<list.size()-1; i++) {
				for(int j=i+1; j<list.size(); j++) {
					max = Math.max(max, gcd(list.get(i), list.get(j)));
				}
			}
			
			sb.append(max+"\n");
		}
		System.out.println(sb.toString());
	}
	
	// 최대공약수 구하는 함수 (유클리드 호제법)
	public static int gcd(int a, int b) {
		if( b == 0 ) return a;
		else return gcd(b, a%b);
	}

}
