package question5_1;

public class Main {
    public static void main(String[] args) {
        System.out.println(myAtoi("     -42"));
        System.out.println(myAtoi("    +--42"));
        System.out.println(myAtoi("4193 with words"));
        System.out.println(myAtoi("words and 987"));
        System.out.println(myAtoi("-91283472332"));
    }

    //Time Complexity: o(n)
    //Space Complexity: o(1)
    public static int myAtoi(String s) {
        int len = s.length();
        char[] charArray = s.toCharArray();

        int index = 0;
        while(index < len && charArray[index] == ' ') index++;

        if(index == len) return 0;

        int sign = 1;
        char firstChar = charArray[index];
        if(firstChar == '+') index++;
        else if(firstChar == '-') {
            index++;
            sign = -1;
        }

        //judge number
        int res = 0;
        while(index < len) {
            char currChar = charArray[index];
            if(currChar > '9' || currChar < '0') break;

            if (res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)) {
                return Integer.MAX_VALUE;
            }
            if (res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))) {
                return Integer.MIN_VALUE;
            }

            res = res * 10 + sign * (currChar - '0');
            index++;
        }
        return res;
    }
}
