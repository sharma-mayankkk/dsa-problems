package STRIVERaTOz.Strings.Hard;
//n = 1: return 1 is the base case
//n = 2: return count of last entry i.e. 1 1
//n = 3: return count of last entry i.e. two 1's so 21
//n=4: we have one 2 and one 1 so 1211
//n=5: , we have one 1 and one 2 and two 1's so -> 111221
//n=6: we have three 1's, two 2's and one 1 so -> 312211
//n = 7: we have one 3, one 1, two 2's and two 1's -> 13112221
//...
//n = i: return counts in front of the number for entry of i-1 case
public class string_01 {
    public static String countAndSay(int n){
        if(n==1) return "1";
        String say = countAndSay(n-1);

        StringBuilder sb = new StringBuilder();

        for(int i=0; i<say.length(); i++){
            char ch = say.charAt(i);
            int count = 1;

            while(i<say.length()-1 && say.charAt(i+1)==ch){
                count++;
                i++;
            }

            sb.append(count).append(ch);
        }
        return sb.toString();
    }

    public static void main(String[] args) {
        System.out.println(countAndSay(2));
    }
}
