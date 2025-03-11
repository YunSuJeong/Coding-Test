import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = "";
		
		// 720분까지 각도 세팅
		Set<Integer> set = new HashSet<Integer>();
		for(int i=0; i<=720; i++) {
			int min = i * 6;
			int hour = i / 12 * 6;
			int angle = Math.abs(min-hour);
			
			if( angle <= 180 ) set.add(angle);
			else set.add(360-angle);
		}
		
		
		while( (str=br.readLine()) != null ) {
			if( set.contains(Integer.parseInt(str)) ) 
				System.out.println("Y");
			else 
				System.out.println("N");
		}
	}

}
