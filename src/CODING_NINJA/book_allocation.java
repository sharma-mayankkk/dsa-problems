package CODING_NINJA;

import java.util.ArrayList;
import java.util.Collections;
//Problem statement
//Given an array ‘arr’ of integer numbers, ‘arr[i]’ represents the number of pages in the ‘i-th’ book.

//There are ‘m’ number of students, and the task is to allocate all the books to the students.

//Allocate books in such a way that:
//1. Each student gets at least one book.
//2. Each book should be allocated to only one student.
//3. Book allocation should be in a contiguous manner.

//You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum.
//If the allocation of books is not possible, return -1.
public class book_allocation {
    public static boolean isValid(ArrayList<Integer> arr, int m, int maxPages) {
        int studentCount = 1;
        int pages = 0;

        for (int i : arr) {
            if (pages + i <= maxPages) {
                pages += i;
            } else {
                studentCount++;
                if (i > maxPages || studentCount > m) {
                    return false;
                } else {
                    pages = i;
                }
            }
        }
        return true;
    }

    public static int findPages(ArrayList<Integer> arr, int n, int m) {

        // Write your code here.
        if (n < m || n == 0) return -1;

        int low = Collections.max(arr), high = 0;
        for (int i : arr) {
            high += i;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, m, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }
}
