package LEETCODE;

import java.util.HashMap;

//Roman to Integer:
public class leetCode_13 {
    public static int romanToInt(String s){
        HashMap<Character, Integer> mpp = new HashMap<>();
        mpp.put('I', 1);
        mpp.put('V', 5);
        mpp.put('X', 10);
        mpp.put('L', 50);
        mpp.put('C', 100);
        mpp.put('D', 500);
        mpp.put('M', 1000);
        int ans = 0;

        for(int i=0; i<s.length()-1; i++){
            if(mpp.get(s.charAt(i))>=mpp.get(s.charAt(i+1))){
                ans+=mpp.get(s.charAt(i));
            }else {
                ans -= mpp.get(s.charAt(i));
            }
        }
        ans+=mpp.get(s.charAt(s.length()-1));

        return ans;
    }
    public static void main(String[] args) {

    }
}
