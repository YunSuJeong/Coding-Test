public class Main {

	public static void main(String[] args) {
		
		StringBuilder sb = new StringBuilder();
		
		for(int i=1000; i<=9999; i++) {
			int sum10 = 0;
			int num = i;
			// 10진수 각 자리 합
			for(int j=0; j<4; j++) {
				sum10 += num%10;
				num /= 10;
			}
			
			// 12진수 각 자리 합
			num = i;
			int sum12 = 0;
			while(true) {
				if( num <= 0 ) break;
				
				sum12 += num%12;
				num /= 12;
			}

			num = i;
			int sum16 = 0;
			while(true) {
				if( num <= 0 ) break;
				
				sum16 += num%16;
				num /= 16;
			}
			if( sum10 == sum12 && sum12 == sum16 ) sb.append(i+"\n");
		}
		System.out.println(sb.toString());
	}

}
