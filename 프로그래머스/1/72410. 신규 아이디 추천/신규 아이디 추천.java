class Solution {
    public String solution(String new_id) {
        
        // 1단계
        new_id = new_id.toLowerCase();
        
        // 2단계
        new_id = new_id.replaceAll("[^a-z0-9\\-\\_\\.]", "");
        // 3단계
        new_id = new_id.replaceAll("\\.+", ".");
        
        // 4단계
        new_id = new_id.replaceAll("^\\.", "");
        new_id = new_id.replaceAll("\\.$", "");

        // 5단계
        if( new_id.length() == 0 ) new_id = "a";
        
        // 6단계
        if( new_id.length() > 15 ) new_id = new_id.substring(0, 15).replaceAll("\\.$", "");
        
        // 7단계
        if( new_id.length() <= 2 ) {
            char c = new_id.charAt(new_id.length()-1);
            new_id = String.format("%-3s", new_id).replace(' ', c);
        }
        
        return new_id;
    }
}