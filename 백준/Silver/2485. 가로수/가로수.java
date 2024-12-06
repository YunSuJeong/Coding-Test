import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int N = Integer.parseInt(br.readLine());
		
		int tree[] = new int[N];
		for(int i=0; i<N; i++) {
			tree[i] = Integer.parseInt(br.readLine());	// 10억 이하
		}
		
		// 각 가로수 사이의 거리 (중복없이)
		List<Integer> dist = new ArrayList<Integer>();
		for(int i=0; i<N-1; i++) {
			int d = tree[i+1] - tree[i];
			if( !dist.contains(d) ) dist.add(d);
		}
		
		// 가로수 사이 최대 거리 구하기
		int max = dist.get(0);
		for(int i=1; i<dist.size(); i++) {
			max = gcd(max, dist.get(i));
		}
		
		// 심어야하는 가장 적은 나무의 수 = (가로수 총 거리 / 가로수 사이 최대거리 + 1) - 현재 심어져 있는 나무 수
		System.out.println((tree[N-1]-tree[0])/max+1-N);
		
	}
	
	public static int gcd(int a, int b) {
		if(b == 0) return a;
		else return gcd(b, a%b);
	}

}
