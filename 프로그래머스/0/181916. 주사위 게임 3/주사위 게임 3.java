import java.util.*;

class Solution {
    public int solution(int a, int b, int c, int d) {
        int answer = 0;
        int p, q;
        if(a == b && b == c && c == d ) {
            answer = 1111 * a;
        } else if( (a == b && b == c && c != d) 
                  || (a == b && b == d && d != c) 
                  || (a == c && c == d && d != b) 
                  || (b == c && c == d && d != a) ) {
            if(a == b && b == c && c != d) {
                p = a;
                q = d;
            } else if(a == b && b == d && d != c) {
                p = a;
                q = c;
            } else if(a == c && c == d && d != b) {
                p = a;
                q = b;
            } else {
                p = b;
                q = a;
            }
            answer = (10 * p + q) * (10 * p + q);
        } else if( a == b || a == c || a == d || b == c || b == d || c == d ) {
            if( a == b ) {
                if( c == d ) answer = (a+c) * Math.abs(a-c);
                else answer = c * d;
            } else if( a == c ) {
                if( b == d ) answer = (a+b) * Math.abs(a-b);
                else answer = b * d;
            } else if( a == d ) {
                if( b == c ) answer = (a+b) * Math.abs(a-b);
                else answer = b * c;
            } else if( b == c ) {
                if( a == d ) answer = (b+a) * Math.abs(b-a);
                else answer = a * d;
            } else if( b == d ) {
                if( a == c ) answer = (b+a) * Math.abs(b-a);
                else answer = a * c;
            } else {
                if(a == b) answer = (c+a) * Math.abs(c-a);
                else answer = a * b;
            }
        } else {
            int min = a;
            if( b < min ) min = b;
            if( c < min ) min = c;
            if( d < min ) min = d;
            answer = min;
        }
        
        return answer;
    }
}