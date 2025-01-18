import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer stA = new StringTokenizer(br.readLine());
		StringTokenizer stC = new StringTokenizer(br.readLine());
		
		int bx = 0, by = 0, bz = 0;
		int ax = Integer.parseInt(stA.nextToken());
		int ay = Integer.parseInt(stA.nextToken());
		int az = Integer.parseInt(stA.nextToken());
		bx = Integer.parseInt(stC.nextToken()) - az;
		by = Integer.parseInt(stC.nextToken()) / ay;
		bz = Integer.parseInt(stC.nextToken()) - ax;
		
		System.out.printf("%d %d %d\n", bx, by, bz);
	}

}
