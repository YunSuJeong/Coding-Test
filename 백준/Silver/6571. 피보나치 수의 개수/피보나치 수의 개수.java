import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;
import java.util.StringTokenizer;

public class  Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str;

        while ((str = br.readLine()) != null && !str.equals("0 0")) {
            StringTokenizer st = new StringTokenizer(str);
            BigInteger a = new BigInteger(st.nextToken());
            BigInteger b = new BigInteger(st.nextToken());

            // 초기값 설정
            BigInteger f1 = BigInteger.ONE;  // f1 = 1
            BigInteger f2 = BigInteger.valueOf(2);  // f2 = 2
            int count = 0;

            // f1, f2 체크
            if (f1.compareTo(a) >= 0 && f1.compareTo(b) <= 0) count++;
            if (f2.compareTo(a) >= 0 && f2.compareTo(b) <= 0) count++;

            // Fibonacci 계산
            BigInteger fn = f1.add(f2);
            while (fn.compareTo(b) <= 0) {
                if (fn.compareTo(a) >= 0) count++;
                f1 = f2;  // 이전 두 값 갱신
                f2 = fn;
                fn = f1.add(f2);
            }

            sb.append(count).append("\n");
        }

        System.out.print(sb);
    }
}
