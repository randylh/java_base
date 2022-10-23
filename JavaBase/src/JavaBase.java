import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import java.util.regex.Pattern;

public class JavaBase {
    static int hash = 0;
    public static int hashCode(String str) {
        int h = hash;
        final int len = str.length();
        if (h == 0 && len > 0) {
            for (int i = 0; i < len; i++) {
                h = 31 * h + str.charAt(i);
            }
            hash = h;
        }
        return h;
    }

    public static void main(String[] args) {
        int h = hashCode("abc");
        System.out.println("hashCode = " + h);


//        List<String> orderIds = new ArrayList<>();
//        orderIds.add("111111");
//        orderIds.add("33333");
//        StringBuilder sb = new StringBuilder();
//        for (String order: orderIds) {
//            sb.append(order).append(",");
//        }
//        String orderIdStr = sb.substring(0, sb.length()-1);
//        System.out.println(orderIdStr);





//        ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();
//
//        int number = 10;
//        //原始数二进制
//        printInfo(number);
//        number = number << 1;
//        //左移一位
//        printInfo(number);
//        number = number >> 1;
//        //右移一位
//        printInfo(number);


//        String content = "65656#key##key#";
//        String content1 = "65656#key##key#";
//        String content2 = "#key##key#65656#key#";
//
//        List<String> contentList = new ArrayList<>();
//        for (int i = 0; i < content.length(); i++) {
//            if (content.contains("#key#")) {
//                if (0 == content.indexOf("#key#")) {
//                    contentList.add("#key#");
//                    if (content.length() > "#key#".length()) {
//                        content = content.substring("#key#".length());
//                    }else {
//                        break;
//                    }
//                }else {
//                    String temp = content.substring(0, content.indexOf("#key#"));
//                    contentList.add(temp);
//                    contentList.add("#key#");
//                    content = content.substring(content.indexOf("#key#")+"#key#".length());
//                }
//            }else {
//                // 如果不包括
//                contentList.add(content);
//                break;
//            }
//        }
//
//        for (String str: contentList) {
//            System.out.println(str);
//        }

    }

    private static void printInfo(int num){
        System.out.println(Integer.toBinaryString(num));
    }

    public static void upgradeLock() {
        ReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.readLock().lock();
        System.out.println("get readLock.");
        rtLock.writeLock().lock();
        System.out.println("blocking");
    }

    public static void degradeLock() {
        ReadWriteLock rtLock = new ReentrantReadWriteLock();
        rtLock.writeLock().lock();
        System.out.println("writeLock");
        rtLock.readLock().lock();
        System.out.println("get read lock");
    }

    public static boolean isNumber(String string) {
        if (string == null)
            return false;
        Pattern pattern = Pattern.compile("^-?\\d+(\\.\\d+)?$");
        return pattern.matcher(string).matches();
    }
}
