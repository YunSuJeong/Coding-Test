import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int billY = 0, billM = 0;
		for(int i=0; i<N; i++) {
			int time = Integer.parseInt(st.nextToken());
			
			billY += (time/30+1)*10;
			billM += (time/60+1)*15;
		}
		
		if( billY == billM ) sb.append("Y M "+billY);
		else sb.append( billY < billM ? "Y "+billY : "M "+billM);
		
		System.out.println(sb.toString());
	}

}
