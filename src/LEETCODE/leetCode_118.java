package LEETCODE;
import java.util.*;

//Given an integer numRows, return the first numRows of Pascal's triangle.
public class leetCode_118 {
    public static List<Integer> genPascalTriangle(int n){
        List<Integer> row = new ArrayList<>();
        row.add(1);

        Integer value = 1;
        for(int i=1; i<n; i++){
            value = value*(n-i)/i;
            row.add(value);
        }
        return row;
    }
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> ans = new ArrayList<>();
        for(int i=1; i<=numRows; i++){
            ans.add(genPascalTriangle(i));
        }
        return ans;
    }
}
