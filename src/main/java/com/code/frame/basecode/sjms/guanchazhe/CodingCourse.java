package com.code.frame.basecode.sjms.guanchazhe;

public class CodingCourse extends Course {
    private String name;
    private int price;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    @Override
    public void accept(IVisitor iVisitor) {
        iVisitor.visit(this);
    }

    @Override
    public String toString() {
        return "CodingCourse{" +
                "name='" + name + '\'' +
                ", price=" + price +
                '}';
    }
}
