import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Solution {
	
	public static int n, parkY, total = 0;
	public static int[] arr, rate, weight;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		for(int tc=1; tc<=T; tc++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			n = Integer.parseInt(st.nextToken());
			int m = Integer.parseInt(st.nextToken());
			
			parkY = n;					// 현재 주차 가능한 자리수
			arr = new int[n];			// 주차공간
			rate = new int[n];		// 요금
			weight = new int[m];		// 차량 무게
			Queue<Integer> queue = new LinkedList<Integer>();		// 대기공간
			
			// 요금 및 차량 무게 세팅
			for(int i=0; i<n; i++) {
				rate[i] = Integer.parseInt(br.readLine());
			}
			for(int i=0; i<m; i++) {
				weight[i] = Integer.parseInt(br.readLine());
			}

			// 차량 출입 순서
			for(int i=0; i<2*m; i++) {
				int car = Integer.parseInt(br.readLine());
				if( car < 0 ) {
					exit(Math.abs(car));
					if( !queue.isEmpty() ) {		// 자리생겼을 때, 대기 차량 바로 주차
						parking(queue.poll());
					}
				} else {
					// 주차 가능한 자리가 있을 때
					if( parkY > 0 ) {
						if( !queue.isEmpty() ) {
							queue.offer(car);		// 대기
							car = queue.poll();		// 가장 처음으로 대기한 차 먼저 주차
						} 
						parking(car);
					} else {
						queue.offer(car);
					}
				}
			}
			
			System.out.printf("#%d %d\n", tc, total);
			total = 0;
		}
	}
	
	// 가장 번호가 작은 공간에 주차
	public static void parking(int car) {
		parkY--;
		for(int i=0; i<n; i++) {
			if( arr[i] == 0 ) {
				arr[i] = car;
				break;
			}
		}
	}
	
	// 출차하면서 요금 계산
	public static void exit(int car) {
		parkY++;
		int idx = 0;
		for(int i=0; i<n; i++) {
			if( arr[i] == car ) {
				arr[i] = 0;
				idx = i;
				break;
			}
		}
		total += weight[car-1] * rate[idx];
	}

}
