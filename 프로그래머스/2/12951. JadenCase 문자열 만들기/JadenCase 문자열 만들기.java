class Solution {
    public String solution(String s) {
        String answer = "";
        
        char[] arr = s.toCharArray();
        
        for(int i=0; i<s.length(); i++) {
            if( arr[i] != ' ' ) {
                if( i == 0 || ( i > 0 && arr[i-1] == ' ') ) arr[i] = Character.toUpperCase(arr[i]);
                else arr[i] = Character.toLowerCase(arr[i]);
            }
        }
        
        return String.valueOf(arr);
    }
}