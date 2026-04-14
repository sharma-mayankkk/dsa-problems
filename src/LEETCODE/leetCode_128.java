package LEETCODE;
import java.util.Set;
import java.util.HashSet;
//128. Longest Consecutive Sequence
public class leetCode_128 {
    public int longestConsecutive(int[] nums) {
        if (nums.length == 0) return 0;
        int longest = 1;
        Set<Integer> st = new HashSet<>();

        for (int i : nums) {
            st.add(i);
        }

        for (int i : st) {
            if (!st.contains(i - 1)) {
                int x = i;
                int count = 1;

                while (st.contains(x + 1)) {
                    x += 1;
                    count += 1;
                }
                longest = Math.max(longest, count);
            }

        }
        return longest;
    }
}
