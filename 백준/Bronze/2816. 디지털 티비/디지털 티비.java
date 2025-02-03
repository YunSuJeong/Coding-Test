import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		
		int N = Integer.parseInt(br.readLine());
		
		String arr[] = new String[N];
		int channel = 0;
		for(int i=0; i<N; i++) {
			arr[i] = br.readLine();
		}
		
		// 채널1을 KBS1로 만들기
		while( !arr[channel].equals("KBS1") ) {
			channel++;
			sb.append("1");
		}

        while( !arr[0].equals("KBS1") ) {
			String tmp = arr[channel];
			arr[channel] = arr[channel-1];
			arr[channel-1] = tmp;
			channel--;
			sb.append("4");
		}
		
		if( arr[0].equals("KBS1") ) {
			channel++;
			sb.append("1");
		}
		
		// 채널2를 KBS2로 만들기
		while( !arr[channel].equals("KBS2") ) {
			channel++;
			sb.append("1");
		}

        while( !arr[1].equals("KBS2") ) {
			String tmp = arr[channel];
			arr[channel] = arr[channel-1];
			arr[channel-1] = tmp;
			channel--;
			sb.append("4");
		}
		
		System.out.println(sb.toString());
	}

}
