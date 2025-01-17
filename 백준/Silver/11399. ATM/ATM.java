import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.StringTokenizer;

/*	ATM */
public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		/*List<int[]> list = new ArrayList<int[]>();
		for(int i=0; i<N; i++) {
			list.add(new int[]{i+1, Integer.parseInt(st.nextToken())});
		}
		
		Collections.sort(list, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) { 
				return o1[1]-o2[1];
			}
		});
		
		int time = 0, sum = 0;
		for(int[] a:list) {
			time += a[1];
			sum += time;
		}*/
		
		// 코드 리팩토링
		// Pi만 사용하면 됨, 사람 번호까지 매칭할 필요가 없다..
		int arr[] = new int[N];
		for(int i=0; i<N; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		Arrays.sort(arr);
		
		int time = 0, sum = 0;
		for(int a : arr) {
			time += a;
			sum += time;
		}
		System.out.println(sum);
	}

}
