import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Solution {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			int N = Integer.parseInt(br.readLine());
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int[] arr = new int[N*2];
			for(int i=0; i<N*2; i++) {
				arr[i] = Integer.parseInt(st.nextToken());
			}
			
			int[] sale = new int[N];
			int idx = 0;
			for(int i=0; i<N*2; i++) {
				int n = arr[i];
				
				int remain = n % 3;
				int price = (n / 3) * 4;

				if( remain == 0  ) {
					boolean flag = false;
					for(int j=i+1; j<N*2; j++) {
						if( arr[j] > 0 && arr[j] == price ) {
							flag = true;
							arr[j] = 0;
							break;
						}
					}
					if( flag ) {
						sale[idx] = n;
						idx++;
					}
				}
			}
			
			for(int s : sale) {
				sb.append(s+" ");
			}
			System.out.printf("#%d %s\n", tc, sb.toString());
			sb.setLength(0);
		}
	}

}
