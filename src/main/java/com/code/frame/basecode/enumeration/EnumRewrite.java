package com.code.frame.basecode.enumeration;

/**
 * 用法四：覆盖枚举的方法
 *
 * 下面给出一个toString()方法覆盖的例子
 * 参考地址
 * https://blog.csdn.net/qq_39949109/article/details/80432477
 *  * @author duran
 *  * @date 2020.10.15
 */
public enum EnumRewrite {
    RED("红色", 1),
    GREEN("绿色", 2),
    BLANK("白色", 3),
    YELLOW("黄色", 4);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private EnumRewrite(String name, int index) {
        this.name = name;
        this.index = index;
    }
    //覆盖方法
    @Override
    public String toString() {
        return this.index+"_"+this.name;
    }
}
