import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int arr[][] = new int[101][101];
		for(int i=0; i<4; i++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			
			int minX = Integer.parseInt(st.nextToken());
			int minY = Integer.parseInt(st.nextToken());
			int maxX = Integer.parseInt(st.nextToken());
			int maxY = Integer.parseInt(st.nextToken());
			
			for(int x=minX; x<maxX; x++) {
				for(int y=minY; y<maxY; y++) {
					arr[x][y] = 1;
				}
			}
		}
		int sum = 0;
		for(int i=0; i<=100; i++) {
			for(int j=0; j<=100; j++) {
				if( arr[i][j] > 0 ) sum += 1;
			}
		}
		System.out.println(sum);
	}

}
