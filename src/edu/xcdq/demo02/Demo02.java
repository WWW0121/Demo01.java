package edu.xcdq.demo02;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.Reader;

/**
 * @author huyuansong
 * @date 2021/5/18 18:12
 */
public class Demo02 {
    public static void main(String[] args) throws Exception {
        // reader和 writer 只能操作文本内容
        Reader reader = new FileReader("d:/1.txt");
        FileWriter fileWriter = new FileWriter("d:/111.txt");
        char [] buff = new char[1024];
        int len = 0 ;
        while ( (len= reader.read(buff)) != -1 ) {
            fileWriter.write( buff , 0 , len ) ;
        }
        fileWriter.flush();

        // 关闭输入资源
        reader.close();
        fileWriter.close();

    }
}
