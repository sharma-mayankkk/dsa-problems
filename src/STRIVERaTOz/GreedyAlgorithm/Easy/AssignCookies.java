package STRIVERaTOz.GreedyAlgorithm.Easy;

import java.util.Arrays;

public class AssignCookies {
    public static int assignCookies(int[] greed, int[] cookies) {
        Arrays.sort(greed);
        Arrays.sort(cookies);

        int l = 0, r = 0;
        while (l < cookies.length && r < greed.length) {
            if (cookies[l] >= greed[r]) r++;
            l++;
        }
        return r;
    }

    public static void main(String[] args) {
        System.out.println(assignCookies(new int[]{1, 2, 3}, new int[]{1, 1}));
    }
}
