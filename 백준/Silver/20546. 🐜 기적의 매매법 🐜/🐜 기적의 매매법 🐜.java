import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int cash = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int[] arr = new int[14];
		for(int i=0; i<14; i++) {
			arr[i] = Integer.parseInt(st.nextToken());
		}
		
		int jh = cash, sm = cash;
		int jhStock = 0, smStock = 0;
		
		// 준현의 BNP 전략
		for(int i=0; i<14; i++) {
			if( jh >= cash ) {
				jhStock += (jh / arr[i]);
				jh -= (jh / arr[i]) * arr[i];
			}
		}
		
		// 성민의 33매매법
		int inc = 0, dec = 0;
		for(int i=1; i<14; i++) {
			if( arr[i] > arr[i-1] ) {
				if( inc < 3 ) inc++;
			}
			else inc = 0;
			
			if( arr[i] < arr[i-1] ) {
				if( dec < 3 ) dec++;
			}
			else dec = 0;
			
			if( inc == 3 ) {
				sm += smStock * arr[i];
				smStock = 0;
			}
			if( dec == 3 ) {
				smStock += (sm/arr[i]);
				sm -= (sm/arr[i]) * arr[i];
			}
		}
		
		int bnp = jh + arr[13] * jhStock;
		int timing = sm + arr[13] * smStock;
		String result = "SAMESAME";
		if( bnp > timing ) result = "BNP";
		else if( bnp < timing) result = "TIMING";
		
		System.out.println(result);
	}

}
