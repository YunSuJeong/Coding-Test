import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int len = Integer.parseInt(br.readLine());
		StringTokenizer st1 = new StringTokenizer(br.readLine());
		
		int[] arr = new int[len];
		int[] reverse = new int[len];
		for(int i=0; i<len; i++) {
			int d = Integer.parseInt(st1.nextToken());
			arr[i] = d;
			if( d == 1 || d == 3 ) {
				reverse[i] = d == 1 ? 3 : 1;
			} else {
				reverse[i] = d == 2 ? 4 : 2;
			}
		}
		
		Set<String> set = new HashSet<String>();
		// 오른쪽 방향으로 그린 순서
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				sb.append(arr[(i+j)%len]+" ");
			}
			set.add(sb.toString().trim());
			sb.setLength(0);
		}
		
		// 반대 방향으로 그린 순서
		for(int i=0; i<len; i++) {
			for(int j=0; j<len; j++) {
				sb.append(reverse[(i-j+len)%len]+" ");
			}
			set.add(sb.toString().trim());
			sb.setLength(0);
		}

		int N = Integer.parseInt(br.readLine());
		int count = 0;
		for(int i=0; i<N; i++) {
			String str = br.readLine();
			
			if( set.contains(str) ) {
				count++;
				sb.append(str+"\n");
			}
		}
		System.out.println(count);
		System.out.println(sb.toString());
	}

}
