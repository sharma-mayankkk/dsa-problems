package STRIVERaTOz.Array.Hard;

import java.util.ArrayList;
import java.util.List;

//Program to generate Pascal's Triangle
//Problem Statement: Write a program to generate Pascal's triangle. In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure below:
public class array_00 {
    //To find the element at the coordinates (R,C) where R is the row number and C is the Column number, we can simply simulate the generation of pascal's triangle for R rows. In Pascal’s Triangle, the element at row R and column C corresponds to the binomial coefficient (r-1)C(c-1). To calculate this binomial coefficient, we can simply apply the formula of binomial coefficient i.e. (r-1)!/(c-1)!(r-c)!.
    //Instead of computing full factorials (which can overflow and be slow), we can multiply and divide in a loop to compute the coefficient efficiently.

    //print specific element at the given row and col:
    public static long nCr(int n, int r){
        long res = 1;
        for(int i=0; i<r;i++){
            res *= (n-i);
            res /= (i+1);
        }
        return res;
    }
    //print the nth row in the pascal triangle
    public static List<Long> genPascalsRow(int n){
        List<Long> row = new ArrayList<>();
        row.add(1L);
        long value = 1;
        for(int i=1; i<n; i++){
            value= value*(n-i)/i;
            row.add(value);
        }
        return row;
    }
    //generate the entire pascals' triangle:
    public static List<List<Long>> genPascalTriangle(int n){
        List<List<Long>> ans = new ArrayList<>();
        for(int i = 1; i<n; i++){
            ans.add(genPascalsRow(i));
        }
        return ans;
    }
    public static void main(String[] args) {
        List<List<Long>> triangle = genPascalTriangle(6);
        for(List<Long> i: triangle){
            System.out.println(i);
        }
    }
}
