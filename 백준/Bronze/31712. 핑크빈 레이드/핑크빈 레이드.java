import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		StringTokenizer U = new StringTokenizer(br.readLine());
		StringTokenizer D = new StringTokenizer(br.readLine());
		StringTokenizer P = new StringTokenizer(br.readLine());
		int H = Integer.parseInt(br.readLine());
		
		int Cu = Integer.parseInt(U.nextToken());
		int Du = Integer.parseInt(U.nextToken());
		int Cd = Integer.parseInt(D.nextToken());
		int Dd = Integer.parseInt(D.nextToken());
		int Cp = Integer.parseInt(P.nextToken());
		int Dp = Integer.parseInt(P.nextToken());
		
		H -= (Du + Dd + Dp);
		int time = 0;
		while( H > 0 ) {
			time++;
			
			if( time % Cu == 0 ) H -= Du;
			if( time % Cd == 0 ) H -= Dd;
			if( time % Cp == 0 ) H -= Dp;
		}
		System.out.println(time);
	}

}
