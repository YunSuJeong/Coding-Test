import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		int T = Integer.parseInt(br.readLine());
		
		// 삼각수
		int arr[] = new int[45];
		for(int i=0; i<45; i++) {
			arr[i] = (i+1)*(i+2)/2;
		}
		
		for(int i=0; i<T; i++) {
			int K = Integer.parseInt(br.readLine());
			
			int flag = 0;
			for(int a=0; a<45; a++) {
				for(int b=0; b<45; b++) {
					for(int c=0; c<45; c++) {
						int sum = arr[a]+ arr[b] + arr[c];
						
						if( sum > K ) break;
						
						if( sum == K ) {
							flag = 1;
							break;
						} 
					}
					if(flag == 1) break;
				}
				if( flag == 1 ) break;
			}
			System.out.println(flag);
		}
		
	}

}
