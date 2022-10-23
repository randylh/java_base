package computer;

public class Java_01 {

    public static void main(String[] args) {
        int[] arr = new int[64 * 1024 * 1024];

        // 循环 1
        long start1 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i++) {
            arr[i] *= 3;
        }
        System.out.println("time1=" + (System.currentTimeMillis() - start1));

        // 循环 2
        long start2 = System.currentTimeMillis();
        for (int i = 0; i < arr.length; i += 16) {
            arr[i] *= 3;
        }
        System.out.println("time2=" + (System.currentTimeMillis() - start2));
    }
}
