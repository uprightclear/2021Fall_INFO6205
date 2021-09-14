package question5;

public class Main {
    public static void main(String[] args) {
        String s = "anagram", t = "nagaram";
        System.out.println(isAnagram(s, t));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(s) s = 26
    public static boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();
        int[] arr = new int[26];

        if(m != n) return false;

        for(int i = 0; i < n; i++){
            arr[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < m; i++){
            if(--arr[t.charAt(i) - 'a'] < 0) return false;
        }
        return true;
    }
}
