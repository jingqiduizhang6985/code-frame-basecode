package com.code.frame.basecode.sjms.guanchazhe;

public class VisitorImpl implements IVisitor {
    @Override
    public void visit(FreeCourse freeCourse) {
        System.out.println("课程 "+freeCourse.getName());
    }

    @Override
    public void visit(CodingCourse codingCourse) {
        System.out.println("课程 "+codingCourse.getName()+" "+codingCourse.getPrice());
    }
}
