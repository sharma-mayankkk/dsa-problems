package STRIVERaTOz.Strings.Medium;

public class string_07 {
    public static String reverseAllWords(String s) {
        int n = s.length();
        int i = s.length() - 1;

        StringBuilder sb = new StringBuilder();

        while (i >= 0 && Character.isLetterOrDigit(s.charAt(i))) {
            while (i >= 0 && s.charAt(i) == ' ') {
                i--;
            }
            int j = i;
            while (j >= 0 && s.charAt(j) != ' ') {
                j--;
            }

            sb.append(s, j + 1, i + 1);

            while (j >= 0 && s.charAt(j) == ' ') {
                j--;
            }
            if (j >= 0) {
                sb.append(' ');
            }
            i = j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseAllWords("the sky is blue"));
    }
}
