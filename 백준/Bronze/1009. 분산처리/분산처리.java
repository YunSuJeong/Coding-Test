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
		
		for(int i=0; i<T; i++) {
			String str = br.readLine();
			StringTokenizer st = new StringTokenizer(str);
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			
			//int num = a;
			int data = a % 10 == 0 ? 10 : a%10;
			List<Integer> cycle = new ArrayList<Integer>();
			while(true) {
				
				if( cycle.indexOf(data) >= 0 ) break;
				
				cycle.add(data);
				//num *= a;					// num에 계속 a를 곱하다보면 int형의 범위를 넘어서는 구간이 생길수 있음
				//data = num % 10 == 0 ? 10 : num%10;
				// 어차피 마지막 일의자리의 사이클만 확인하면 되므로 제곱한 값은 필요없다.
				data = data * a % 10 == 0 ? 10 : data*a%10;
			}
			
			int idx = (b%cycle.size() == 0 ? cycle.size()-1 : b%cycle.size()-1);
			sb.append(cycle.get(idx)+"\n");
		}
		System.out.println(sb.toString());
	}

}
