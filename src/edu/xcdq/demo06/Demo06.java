package edu.xcdq.demo06;

import java.io.*;

/**
 * @author wangwenbo
 * @data 2021/5/20 9:26
 */
public class Demo06 {
    public Demo06() throws IOException {
    }

    public static void main(String[] args) throws IOException,ClassNotFoundException{
        //顺序华
        Person p1 = new Person("zhangsan",18);
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream("temp"));
        oos.writeObject(p1);
        //
      ObjectInputStream ois = new ObjectInputStream(new FileInputStream("temp"));
        Person p = (Person) ois.readObject();
        System.out.println(p);
    }
    User lisi = new User("lisi",20);
    ObjectOutputStream oos1 = new ObjectOutputStream(new FileOutputStream("tempFile"));

    ObjectInputStream ois1 = new ObjectInputStream(new FileInputStream("tempFile"));

}
