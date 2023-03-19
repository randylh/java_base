package jvm;

public class InitDemo {

    // 静态代码块是在初始化阶段才被执行，因此在初始化阶段去修改i的值
    // i变量已经存在了，编译是通过的
    // 但是如果想直接在静态代码块里打印这个i变量是不允许的
    static {
        i = 20;
//        System.out.println(i);
    }

    // 变量i是在准备阶段被分配内存并赋值为初始化默认值0
    public static int i = 10;
}
