package com.code.frame.basecode.sjms.guanchazhe;

public class FreeCourse extends Course {
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "FreeCourse{" +
                "name='" + name + '\'' +
                '}';
    }
}
