package STRIVERaTOz.Array.Hard;

import java.util.*;

//3 Sum : Find triplets that add up to a zero
public class array_02 {
    //BruteForce Approach:
    public static List<List<Integer>> threeSum(int[] arr) {
        Set<List<Integer>> set = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    if (arr[i] + arr[j] + arr[k] == 0) {
                        //storing sorted triplet to avoid duplicates;
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                        Collections.sort(temp);
                        set.add(temp);
                    }
                }
            }
        }
        return new ArrayList<>(set);
    }

    //Better solution:
    public static List<List<Integer>> threeSum2(int[] arr) {
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int thirdEle = -(arr[i] + arr[j]);
                if (set.contains(thirdEle)) {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], thirdEle);
                    Collections.sort(temp);
                    ans.add(temp);
                }
                set.add(arr[j]);
            }
            set.clear();
        }
        return new ArrayList<>(ans);
    }

    //Optimal Solution:
    public static List<List<Integer>> threeSum3(int[] arr) {
        Arrays.sort(arr);
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int j = i + 1;
            int k = arr.length - 1;

            while (j < k) {
                int sum = arr[i] + arr[j] + arr[k];
                if (sum < 0) {
                    j++;
                } else if (sum > 0) {
                    k--;
                } else {
                    List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k]);
                    ans.add(temp);
                    j++;
                    k--;
                    while (j < k && arr[j] == arr[j - 1]) j++;
                    while (j < k && arr[k] == arr[k + 1]) k--;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        int[] arr = {-1, 0, 1, 2, -1, -4};
        System.out.println(threeSum3(arr));
    }
}
