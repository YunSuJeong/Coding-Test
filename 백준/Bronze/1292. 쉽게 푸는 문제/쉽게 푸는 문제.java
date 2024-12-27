import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		
		List<Integer> list = new ArrayList<Integer>();
		int num = 1, cnt = 0;
		for(int i=0; i<1000; i++) {
			cnt++;
			list.add(num);
			if(cnt == num) {
				num++;
				cnt = 0;
			}
		}

		int sum = 0;
		for(int i=A-1; i<B; i++) {
			sum += list.get(i);
		}
		System.out.println(sum);
	}

}
