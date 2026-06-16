package STRIVERaTOz.Strings;
//Given an input string s, reverse the order of the words.
//
//A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.
//
//Return a string of the words in reverse order concatenated by a single space.
public class string_07 {
    public static String reverseStrings(String s){
        StringBuilder sb = new StringBuilder();

        int i=s.length()-1;

        while(i>=0){
            //remove all the trailing spaces:
            while(i>=0 && s.charAt(i) == ' '){
                i--;
            }

            //check value of i;
            if(i<0) break;

            //new pointer j with value of i;
            int j = i;
            while(j>=0 && s.charAt(j) != ' '){
                j--;
            }

            // now will be on valid index so append this word in the new sb;
            sb.append(s, j+1, i+1);

            //remove unwanted spaces where j is standing:
            while(j>=0 && s.charAt(j) == ' '){
                j--;
            }

            //adding spaces after each word;
            if(j>=0){
                sb.append(' ');
            }

            //place i at the last index where j was remaining;
            i=j;
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(reverseStrings("I     am    batman   "));
    }
}
