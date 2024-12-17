import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		
		String str = br.readLine();
		StringTokenizer st = new StringTokenizer(str);
		
		int arr[] = new int[N];
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<N; i++) {
			int x =  Integer.parseInt(st.nextToken());
			arr[i] = x;
			set.add(x);
		}
		
		List<Integer> sort = new ArrayList<Integer>(set);
		Collections.sort(sort);
		
		// 1) indexOf로 탐색
//		for(int i=0; i<N; i++) {
//			bw.write(sort.indexOf(arr[i])+" ");
//		}
		
		// 2) binarySearch 탐색
		for(int i=0; i<N; i++) {
			int start = 0, end = sort.size()-1, mid = 0;
			while( start <= end ) {
				mid = (start+end)/2;
				if( arr[i] == sort.get(mid) ) break;
				
				if( arr[i] < sort.get(mid) ) {
					end = mid - 1;
				} else {
					start = mid + 1;
				}
			}
			bw.write(mid+" ");
		}
		
		bw.flush();
		bw.close();
	}

}
