package computer;

public class Java_02 {

    public static void main(String[] args) {
        int m = 20000;
        int n = 10000;
        int[][] arr = new int[m][n];
        for (int i =0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                arr[i][j] = 1;
            }
        }

        // 行
        sumByLine(m, n, arr);
        // 列
        sumByRow(m, n, arr);
    }

    private static void sumByRow(int m, int n, int[][] arr) {
        int i, j, sum = 0;
        long start0 = System.currentTimeMillis();
        for (j = 0; j < n; j++) {
            for (i = 0; i < m; i++) {
                sum += arr[i][j];
            }
        }
        System.out.println("按列遍历：time=" + (System.currentTimeMillis() - start0) + ", sum=" + sum);
    }

    private static void sumByLine(int m, int n, int[][] arr) {
        int i, j, sum = 0;
        long start1 = System.currentTimeMillis();
        for (i = 0; i < m; i++) {
            for (j = 0; j < n; j++) {
                sum += arr[i][j];
            }
        }
        System.out.println("按行遍历：time=" + (System.currentTimeMillis() - start1) + ", sum=" + sum);
    }
}
