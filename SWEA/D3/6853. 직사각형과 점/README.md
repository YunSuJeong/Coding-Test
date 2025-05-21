# [D3] 직사각형과 점 - 6853 

[문제 링크](https://swexpertacademy.com/main/code/problem/problemDetail.do?contestProbId=AWhT_2HKQNADFAW_) 

## 문제 풀이
점(x, y)의 위치 판별하는 문제 
- 직사각형 **내부** : x, y가 주어진 직사각형의 좌표보다 작아야한다. x1 < x < x2 && y1 < y < y2
- 직사각형의 **네 변 중 적어도 하나의 위** : 직사각형의 세로변에 있는 경우, 가로변에 있는경우
    - 세로 : x가 x1 또는 x2와 같고, y는 세로변의 범위 내
    - 가로 : y가 y1 또는 y2와 같고, x는 가로면의 범위 내
- 직사각형 **외부** : 위 두가지 경우를 제외한 모든 경우

### 성능 요약

메모리: 73,748 KB, 시간: 205 ms, 코드길이: 1,195 Bytes

### 제출 일자

2025-05-20 14:37



> 출처: SW Expert Academy, https://swexpertacademy.com/main/code/problem/problemList.do
