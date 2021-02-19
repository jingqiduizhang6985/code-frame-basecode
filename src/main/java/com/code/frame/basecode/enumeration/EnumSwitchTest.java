package com.code.frame.basecode.enumeration;

/**
 * JDK1.6之前的switch语句只支持int,char,enum类型，使用枚举，能让我们的代码可读性更强。
 */
public class EnumSwitchTest {
    public static void change(EnumSwitch color) {
        String colorStr = "";
        switch (color) {
            case RED:
                colorStr = "红色";
                break;
            case YELLOW:
                colorStr = "黄色";
                break;
            case GREEN:
                colorStr = "绿色";
                break;
        }
        System.out.println(color + "-----" + colorStr);
    }

    public static void main(String[] args) {
        EnumSwitchTest.change(EnumSwitch.RED);
        EnumSwitchTest.change(EnumSwitch.GREEN);
        EnumSwitchTest.change(EnumSwitch.YELLOW);
    }
}
