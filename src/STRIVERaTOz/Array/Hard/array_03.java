package STRIVERaTOz.Array.Hard;
//4 sum problem:
import java.util.*;

public class array_03 {
    public static List<List<Integer>> fourSum(int[] arr, int target) {
        Set<List<Integer>> ans = new HashSet<>();
        Set<Integer> set = new HashSet<>();

        for (int i = 0; i < arr.length; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                for (int k = j + 1; k < arr.length; k++) {
                    int fourthEle = target - (arr[i] + arr[j] + arr[k]);
                    if (set.contains(fourthEle)) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], fourthEle);
                        Collections.sort(temp);
                        ans.add(temp);
                    }
                    set.add(arr[k]);
                }
                set.clear();
            }
        }
        return new ArrayList<>(ans);
    }

    //Optimal Solution:
    public static List<List<Integer>> fourSum2(int[] arr, int target) {
        Arrays.sort(arr);
        int n = arr.length;
        Set<List<Integer>> ans = new HashSet<>();
        for (int i = 0; i < n; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;
            for (int j = i + 1; j < n; j++) {
                if (j != i + 1 && arr[j] == arr[j - 1]) continue;

                int k = j + 1;
                int l = n - 1;

                while (k < l) {
                    long sum = arr[i];
                    sum += arr[j];
                    sum += arr[k];
                    sum += arr[l];

                    if (sum == target) {
                        List<Integer> temp = Arrays.asList(arr[i], arr[j], arr[k], arr[l]);
                        ans.add(temp);
                        k++;
                        l--;

                        while (k < l && arr[k] == arr[k + 1]) k++;
                        while (k < l && arr[l] == arr[l - 1]) l--;
                    } else if (sum < target) {
                        k++;
                    } else l--;
                }
            }
        }
        return new ArrayList<>(ans);
    }

    public static void main(String[] args) {
        int[] arr = {1, 0, -1, 0, -2, 2, 3, 2};
        System.out.println(fourSum2(arr, 4));

    }
}
