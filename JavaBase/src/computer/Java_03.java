package computer;

import java.util.*;

public class Java_03 {

    public static void main(String[] args) {
        final int arraySize = 32768;

        Random random = new Random();
        List<Integer> data = new ArrayList<>(arraySize);
        for (int c = 0; c < arraySize; c++) {
            data.add(random.nextInt(256));
        }
        // TODO 这里是否对数组排序，结果相差较大
        Collections.sort(data);

        long start = System.currentTimeMillis();
        long sum = 0;
        for (int i = 0; i < 100000; i++) {
            for (int j = 0; j < arraySize; j++) {
                if (data.get(j) > 128) {
                    sum += data.get(j);
                }
            }
        }

        System.out.println("cost=" + (System.currentTimeMillis() - start) / 1000);
        System.out.println("sum=" + sum);
    }
}
