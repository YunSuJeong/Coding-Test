class Solution {
    public int solution(String[] babbling) {
        int answer = 0;
        String[] word = {"aya", "ye", "woo", "ma"};
        
        // 반복 : babbling[] 길이 * 4
        for(int i=0; i<babbling.length; i++) {
            int j = 0, idx = babbling[i].indexOf(word[j]);
            // 4가지 발음 중 포함되는 발음이 있다면 공백으로 치환
            while( j < 4 ) {
                // 단어에 더 이상 해당 발음이 존재하지 않는다면 다음 발음으로 반복
                if( babbling[i].indexOf(word[j]) < 0 ) {
                    j++;
                    continue;
                }
                
                idx = babbling[i].indexOf(word[j]);     // 단어 내 발음의 첫 위치
                babbling[i] = babbling[i].replaceFirst(word[j], " ");
                
                // 연속해서 같은 발음인 경우, 다음 발음으로 넘어감
                // '연속'의 기준 = (현재 발음 첫 위치 + 1(공백) == 발음의 다음 위치) 
                if( idx + 1 == babbling[i].indexOf(word[j]) ) j++;
            }
            // 공백을 없앤 단어길이가 0이라면, 발음 가능한 단어이므로 카운팅
            if( babbling[i].replace(" ", "").length() == 0 ) answer++;
        }
        
        return answer;
    }
}