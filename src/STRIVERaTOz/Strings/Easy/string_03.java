package STRIVERaTOz.Strings.Easy;
//Longest common prefix:

public class string_03 {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }

        int preLen = 0;
        while (true) {
            boolean allGood = true;
            if (preLen < strs[0].length()) {
                char ch = strs[0].charAt(preLen);
                for (int i = 1; i < strs.length; i++) {
                    if (!(strs[i].length() > preLen && strs[i].charAt(preLen) == ch)) {
                        allGood = false;
                        break;
                    }
                }
                if (allGood) {
                    preLen++;
                } else {
                    break;
                }
            } else {
                break;
            }
        }

        return strs[0].substring(0, preLen);
    }
}
