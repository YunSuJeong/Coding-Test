import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		boolean[] arr = new boolean[N+1];
		List<Integer> list1 = new ArrayList<Integer>();
		List<Integer> list2 = new ArrayList<Integer>();

		for(int i=0; i<N; i++) {
			int n =  Integer.parseInt(br.readLine());
			if( n > N || arr[n] ) list1.add(n);
			if( n <= N ) arr[n] = true;
		}
		
		Collections.sort(list1);
		
		for(int i=1; i<=N; i++) {
			if( !arr[i] ) list2.add(i);
		}
		
		long min = 0;
		for(int i=0; i<list1.size(); i++) {
			min += (long)Math.abs(list1.get(i)-list2.get(i));
		}
		System.out.println(min);
	}

}
