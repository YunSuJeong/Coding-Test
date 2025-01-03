import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		String str = br.readLine();
		
		int come[] = new int[26];			// 들어온 길
		int go[] = new int[26];				// 나간 길
		for(int i=0; i<52; i++) {
			int idx = str.charAt(i)-65; 
			if( come[idx] > 0 ) {
				go[idx] = i+1;
			} else {
				come[idx] = i+1;
			}
		}
		
		
		// 만나는 쌍의 개수 구하기
		int cnt = 0;
		for(int i=0; i<26; i++) {
			for(int j=0; j<26; j++) {
				if( come[i] < come[j] && come[j] < go[i] && go[i] < go[j] ) cnt++;
			}
		}
		System.out.println(cnt);
	}

}
