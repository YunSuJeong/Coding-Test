class Solution {
    
    public int mm, ss;
    
    public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
        // 현재 재생 위치
        mm = Integer.parseInt(pos.split(":")[0]);
        ss = Integer.parseInt(pos.split(":")[1]);
        
        int video_mm = Integer.parseInt(video_len.split(":")[0]), video_ss = Integer.parseInt(video_len.split(":")[1]);
        int start_mm = Integer.parseInt(op_start.split(":")[0]), start_ss = Integer.parseInt(op_start.split(":")[1]);
        int end_mm = Integer.parseInt(op_end.split(":")[0]), end_ss = Integer.parseInt(op_end.split(":")[1]);
        
        isOpening(start_mm, start_ss, end_mm, end_ss);
        System.out.println(mm+" "+ss);
        for(String c : commands) {
            if( c.equals("prev") ) {
                if( mm == 0 && ss < 10 ) {
                    mm = 0;
                    ss = 0;
                } else {
                    ss -= 10;
                    if( ss < 0 ) {
                        ss += 60;
                        mm--;
                    }
                }
            } else {
                ss += 10;
                if( ss >= 60 ) {
                    ss %= 60;
                    mm++;
                }
                
                if( mm > video_mm || (mm == video_mm && ss > video_ss) ) {
                    mm = video_mm;
                    ss = video_ss;
                }
            }
            
            isOpening(start_mm, start_ss, end_mm, end_ss);
        }
        
        return String.format("%02d:%02d", mm, ss);
    }
    
    // 현재 재생 위치가 오프닝 구간인지 확인
    public void isOpening(int start_mm, int start_ss, int end_mm, int end_ss) {
        if( !(mm < start_mm 
           || mm > end_mm 
           || (mm == start_mm && ss < start_ss)
           || (mm == end_mm && ss > end_ss)) ) {
            mm = end_mm;
            ss = end_ss;
        }
    }
}