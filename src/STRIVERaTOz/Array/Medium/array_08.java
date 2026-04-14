package STRIVERaTOz.Array.Medium;
//Set Matrix Zero
//Problem Statement: Given a matrix if an element in the matrix is 0 then you will have to set its entire column and row to 0 and then return the matrix.
public class array_08 {
    public static void markRow(int[][] arr, int row){
        int n = arr[0].length;

        for(int i=0; i<n; i++){
            if(arr[row][i] !=0){
                arr[row][i]=-1;
            }
        }

    }
    public static void markCol(int[][] arr, int col){
        int n = arr.length;

        for(int i=0; i<n; i++){
            if(arr[i][col]!=0){
                arr[i][col]=-1;
            }
        }
    }

    //BruteForce Approach;
    public static void markMatrixZero(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j] == 0){
                    markRow(arr,i);
                    markCol(arr,j);
                }
            }
        }
        for(int i =0; i<m; i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==-1){
                    arr[i][j]=0;
                }
            }
        }
    }

    //Better solution:
    public static void setZero(int[][] arr){
        int m = arr.length;
        int n = arr[0].length;

        boolean[] row = new boolean[m];
        boolean[] col = new boolean[n];

        for(int i=0; i<m;i++){
            for(int j=0; j<n; j++){
                if(arr[i][j]==0){
                    row[i] = true;
                    col[j] = true;
                }
            }
        }

        for(int i=0; i<m; i++){
            for(int j=0; j<n; j++){
                if(row[i] || col[j]){
                    arr[i][j] = 0;
                }
            }
        }


    }

    public static void main(String[] args) {
        int[][] arr = {
                {1, 2, 3},
                {4, 0, 6},
                {7, 8, 9}
        };
        setZero(arr);

        for(int i=0; i<arr.length; i++){
            for(int j=0;j<arr[0].length;j++){
                System.out.print(arr[i][j]+" ");
            }
            System.out.println();
        }

    }
}
