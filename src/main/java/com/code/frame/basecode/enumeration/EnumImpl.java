package com.code.frame.basecode.enumeration;

/**
 * 用法五：实现接口
 *
 * 所有的枚举都继承自java.lang.Enum类。由于Java 不支持多继承，所以枚举对象不能再继承其他类。
 * 参考地址
 * https://blog.csdn.net/qq_39949109/article/details/80432477
 *  * @author duran
 *  * @date 2020.10.15
 */
public enum EnumImpl implements IEnum {
    RED("红色", 1),
    GREEN("绿色", 2),
    BLANK("白色", 3),
    YELLOW("黄色", 4);
    // 成员变量
    private String name;
    private int index;
    // 构造方法
    private EnumImpl(String name, int index) {
        this.name = name;
        this.index = index;
    }
    //接口方法
    @Override
    public String getInfo() {
        return this.name;
    }
    //接口方法
    @Override
    public void print() {
        System.out.println(this.index+":"+this.name);
    }
}
