package com.code.frame.basecode.reflex;

import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Method;
import java.util.Properties;

/**
 * 反射方法的其它使用之---通过反射运行配置文件内容
 *
 * 配置文件内容
 * className = com.code.frame.basecode.reflex.bean.Student
 * methodName = show
 */
public class ReflexConfigure {
    public static void main(String[] args) throws Exception {
//        String className  = "com.code.frame.basecode.reflex.bean.Student";
//        String methodName = "show";
        //通过配置文件获取内容
        String className = getValue("className");
        String methodName = getValue("methodName");

        //1 通过反射获取Class对象
        Class stuClass = Class.forName(className);//"com.code.frame.basecode.reflex.bean.Student
        //2获取show()方法
        Method m = stuClass.getMethod(methodName);//show
        //3.调用show()方法
        m.invoke(stuClass.getConstructor().newInstance());

    }

    //此方法接收一个key，在配置文件中获取相应的value
    public static String getValue(String key) throws IOException {
        Properties pro = new Properties();//获取配置文件的对象
        String fileName = "F:/workitem/item_code_frame/code-frame-basecode/src/main/resources/pro.txt";
//        FileReader in = new FileReader("pro.txt");//获取输入流
        FileReader in = new FileReader(fileName);//获取输入流


        pro.load(in);//将流加载到配置文件对象中
        in.close();
        return pro.getProperty(key);//返回根据key获取的value值
    }
}
