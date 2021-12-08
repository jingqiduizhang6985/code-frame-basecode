package com.code.frame.basecode.sjms.guanchazhe;

import java.util.ArrayList;
import java.util.List;

public class Test {
    public static void main(String[] args) {
        List<Course> list = new ArrayList<>();

        FreeCourse freeCourse = new FreeCourse();
        freeCourse.setName("免费课程");
        list.add(freeCourse);
        CodingCourse codingCourse = new CodingCourse();
        codingCourse.setName("收费课程");
        codingCourse.setPrice(299);
        list.add(codingCourse);

        for(Course course:list){
            course.accept(new VisitorImpl());
        }
    }
}
