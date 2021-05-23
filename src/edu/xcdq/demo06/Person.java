package edu.xcdq.demo06;

import java.io.Serializable;

/**
 * @author wangwenbo
 * @data 2021/5/20 9:26
 */
public class Person implements Serializable {
    private String name;
    private int sge;

    public Person() {
    }

    public Person(String zhangsan, int age) {
    }

    public String getName() {
        return name;
    }

    public int getSge() {
        return sge;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSge(int sge) {
        this.sge = sge;
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", sge=" + sge +
                '}';
    }
}
