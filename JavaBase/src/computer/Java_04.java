package computer;

public class Java_04 {

    public static void main(String[] args) {
        int[] a = new int[100000];
        int[] b = new int[100000];
        for (int j = 0; j < 10; j++) {
            a[j] = j;
            b[j] = j+20;
        }
        long start = System.currentTimeMillis();
        for(int i = 0; i < 100000; i++) {
            a[i] = b[i];
        }

        System.out.println("cost=" + (System.currentTimeMillis()-start));
    }
}
