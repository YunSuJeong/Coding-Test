import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.TreeSet;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());

		int init = Integer.parseInt(br.readLine());
		int arr[] = new int[N];							// 중앙값을 구하기 위한 배열
		Map<Integer, Integer> map = new HashMap<Integer, Integer>();

		// 초기화
		int max = init, min = init, sum = init;
		arr[0] = init;
		map.put(init, 1);
		for(int i=1; i<N; i++) {
			int num = Integer.parseInt(br.readLine());
			sum += num;
			arr[i] = num;
			map.put(num, map.containsKey(num) ? map.get(num)+1 : 1 );
			// 범위 계산을 위한 최대, 최솟값 구하기
			max = Math.max(max, num);
			min = Math.min(min, num);
		}
		
		Arrays.sort(arr);
		
		int maxCnt = 0;
		for(int v : map.values()) {
			maxCnt = Math.max(maxCnt, v);
		}
		
		List<Integer> mode = new ArrayList<Integer>();
		for(Entry<Integer, Integer> entry : map.entrySet()) {
			if( entry.getValue() == maxCnt ) {
				mode.add(entry.getKey());
			}
		} 
		Collections.sort(mode);
		
		System.out.println(Math.round(sum/(N*1.0)));
		System.out.println(arr[N/2]);
		System.out.println(mode.size() == 1 ? mode.get(0) : mode.get(1));
		System.out.println(max-min);
	}

}
