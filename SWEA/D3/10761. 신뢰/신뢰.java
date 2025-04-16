import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int T = sc.nextInt();  // 테스트 케이스 수

        for (int tc = 1; tc <= T; tc++) {
            int N = sc.nextInt();  // N의 값

            Queue<String> sequence = new LinkedList<String>();
            Queue<Integer> blue = new LinkedList<Integer>();
            Queue<Integer> orange = new LinkedList<Integer>();

            // sequence 큐와 blue, orange 큐에 값을 넣기
            for (int i = 0; i < N; i++) {
                String type = sc.next();  // "O" 또는 "B"
                int num = sc.nextInt();  // 버튼 번호

                sequence.offer(type);

                if (type.equals("O")) {
                    orange.offer(num);
                } else {
                    blue.offer(num);
                }
            }

            int sec = 0;
            int o = 1, b = 1;  // i초 지났을 때, 로봇들의 위치
            boolean isPush = false;

            while (!sequence.isEmpty()) {
                sec++;
                isPush = false;  // 버튼 동시누름 방지 플래그

                // Orange 버튼 처리
                if (!orange.isEmpty()) {
                    if (o == orange.peek()) {
                        if (sequence.peek().equals("O")) {
                            isPush = true;
                            orange.poll();
                        }
                    } else if (o < orange.peek()) {
                        o++;
                    } else if (o > orange.peek()) {
                        o--;
                    }
                }

                // Blue 버튼 처리
                if (!blue.isEmpty()) {
                    if (b == blue.peek()) {
                        if (sequence.peek().equals("B")) {
                            isPush = true;
                            blue.poll();
                        }
                    } else if (b < blue.peek()) {
                        b++;
                    } else if (b > blue.peek()) {
                        b--;
                    }
                }

                // 버튼을 눌렀다면
                if (isPush) {
                    sequence.poll();
                }
            }

            // 결과 출력
            System.out.printf("#%d %d\n", tc, sec);
        }

        sc.close();
    }
}
