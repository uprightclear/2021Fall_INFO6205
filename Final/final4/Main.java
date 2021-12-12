package final4;

public class Main {
    public static void main(String[] args) {
        String[] words = {"hello", "leetcode"};
        String order = "hlabcdefgijkmnopqrstuvwxyz";

        String[] words1 = {"word", "world", "row"};
        String order1 = "worldabcefghijkmnpqstuvxyz";
        System.out.println(isOrder(words, order));
        System.out.println(isOrder(words1, order1));
    }

    public static boolean isOrder(String[] words, String order) {
        int[] pos = new int[26];
        for(int i = 0; i < order.length(); i++) {
            //System.out.println(order.charAt(i) - 'a');
            pos[order.charAt(i) - 'a'] = i;
        }
        for(int i = 1; i < words.length; i++) {
            String first = words[i - 1];
            String second = words[i];
            if(first.startsWith(second) && first.length() > second.length()) return false;
            int len = Math.min(first.length(), second.length());
            for(int j = 0; j < len; j++) {
                int f = first.charAt(j) - 'a';
                int s = second.charAt(j) - 'a';
                if(f != s) {
                    if(pos[f] > pos[s]) return false;
                    break;
                }
            }
        }
        return true;
    }
}
