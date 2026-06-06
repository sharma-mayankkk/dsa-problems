package STRIVERaTOz.BinarySearching.BSonAnswers;

//Allocate Minimum Number of Pages
//Problem Statement: Given an array ‘arr of integer numbers, ‘ar[i]’ represents the number of pages in the ‘i-th’ book. There are a ‘m’ number of students, and the task is to allocate all the books to the students.
//Allocate books in such a way that:
//Each student gets at least one book.
//Each book should be allocated to only one student.
//Book allocation should be in a contiguous manner.
//You have to allocate the book to ‘m’ students such that the maximum number of pages assigned to a student is minimum. If the allocation of books is not possible. return -1
public class array_08 {
    public static boolean isValid(int[] arr, int k, int maxPages) {
        int studentCount = 1;
        int pages = 0;

        for (int i : arr) {
            if (pages + i <= maxPages) {
                pages += i;
            } else {
                studentCount++;
                if (studentCount > k || i > maxPages) {
                    return false;
                } else {
                    pages = i;
                }
            }
        }
        return true;
    }

    public static int findPages(int[] arr, int k) {

        if (arr.length < k) {
            return -1;
        }

        int low = 0, high = 0;
        for (int i : arr) {
            low = Math.max(i, low);
        }
        for (int i : arr) {
            high += i;
        }

        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (isValid(arr, k, mid)) {
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return low;
    }

    public static void main(String[] args) {
        int[] arr = {12, 34, 67, 90};
        System.out.println(findPages(arr, 2));
    }
}
