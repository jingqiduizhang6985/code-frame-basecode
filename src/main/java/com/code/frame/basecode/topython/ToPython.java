package com.code.frame.basecode.topython;

import org.python.util.PythonInterpreter;

/**
 * java 调用 python文件
 */
public class ToPython {
    public static void main(String[] args) {
        PythonInterpreter interpreter = new PythonInterpreter();
        interpreter.execfile("D:\\python_work\\action\\base_1.py");
    }
}
