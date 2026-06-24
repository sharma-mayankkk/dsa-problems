package STRIVERaTOz.Strings.Hard;

//Given two strings a and b, return the minimum number of times you should repeat string a so that string b is a substring of it. If it is impossible for 'b' to be a substring of "a" after repeating it, return -1.
//Notice: string "abc" repeated 0 times is "", repeated 1 time is "abc" and repeated 2 times is "abcabc".
public class string_03 {
    public static int repeatedStringMatch(String a, String b) {
        StringBuilder repeated = new StringBuilder();
        int count = 0;
        while (repeated.length() < b.length()) {
            repeated.append(a);
            count++;
        }

        if (repeated.indexOf(b) != -1) {
            return count;
        }

        repeated.append(a);
        if (repeated.indexOf(b) != -1) {
            return count + 1;
        }

        return -1;
    }

    public static void main(String[] args) {
        System.out.println(repeatedStringMatch("abcd", "xyz "));
    }
}
