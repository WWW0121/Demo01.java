package edu.xcdq.demo04;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * @author wangwenbo
 * @data 2021/5/20 8:29
 */
public class Demo04 {
    public static void main(String[] args) throws IOException {
        RandomAccessFile red = new RandomAccessFile("d:/","r");
        red.seek(8*1);
        byte[] buf = new byte[4];
        red.read(buf);
        String name = new String(buf);
        System.out.println("name="+ name);

        int age = red.readInt();
        System.out.println("age="+age);
        red.close();

    }
}
