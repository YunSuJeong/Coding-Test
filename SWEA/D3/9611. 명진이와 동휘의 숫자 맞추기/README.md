# [D3] 명진이와 동휘의 숫자 맞추기 - 9611 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AXBbOcTav0QDFAVg) 

## 접근 방식
처음엔 Yes -> No -> No순인 테스트케이스를 보고 0~9까지 4개의 숫자가 Yes면 true로 No이면 false로 바꿔주어 마지막에 true인 수를 출력하도록 구현했었다.  
그럼 No가 먼저나오고 Yes가 나오는 상황에서 가능성이 있는 숫자가 늘어나면서 명진이가 생각한 숫자를 특정할 수 없게 된다.!  
그래서 boolean이 아닌 int형으로 바꾸어 yes면 출현 횟수를 +1, No이면 -1하고, 마지막에 출현 숫자가 가장 큰 수를 구하는 로직으로 구현하였다.  

### 성능 요약

메모리: 26,112 KB, 시간: 82 ms, 코드길이: 840 Bytes

### 제출 일자

2025-05-16 14:08



> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do
