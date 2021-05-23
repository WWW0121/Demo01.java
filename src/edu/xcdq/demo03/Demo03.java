package edu.xcdq.demo03;

import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author huyuansong
 * @date 2021/5/18 18:27
 */
public class Demo03 {
    public static void main(String[] args) throws IOException {
        method1();
    }
    public static void method1() throws IOException {
        // 创建输入流对象
        InputStream is = System.in;
        // 转换
        InputStreamReader isr = new InputStreamReader(is);
        // 创建输出流对象
        FileWriter fw = new FileWriter("d:/demo03.txt");

        // 读写数据
        char[] bys = new char[1024];
        int len;
        while ((len = isr.read(bys)) != -1) {
            fw.write(new String(bys, 0, len));
            fw.flush();
        }
        // 释放资源
        is.close();
        fw.close();
    }

}
