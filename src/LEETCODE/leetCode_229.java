package LEETCODE;
//Given an integer array of size n, find all elements that appear more than ⌊ n/3 ⌋ times.
import java.util.*;
public class leetCode_229 {
    public List<Integer> majorityElement(int[] nums) {
        int cnt1=0, cnt2=0;
        int ele1=Integer.MIN_VALUE, ele2=Integer.MIN_VALUE;

        for(int i: nums){
            if(cnt1==0 && i!=ele2){
                ele1 = i;
                cnt1++;
            }else if(cnt2==0 && i!=ele1){
                ele2 = i;
                cnt2++;
            }else if(ele1==i){
                cnt1++;
            }else if(ele2==i){
                cnt2++;
            }else {
                cnt1--;
                cnt2--;
            }
        }

        cnt1=0;
        cnt2=0;

        for(int i: nums){
            if(i==ele1)cnt1++;
            if(i==ele2) cnt2++;
        }

        List<Integer> ans = new ArrayList<>();
        int min = nums.length/3+1;
        if(cnt1>=min) ans.add(ele1);
        if (cnt2 >= min && ele2 != ele1) ans.add(ele2);

        return ans;
    }
}
