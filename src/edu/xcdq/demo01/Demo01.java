package edu.xcdq.demo01;


import java.io.File;
import java.io.IOException;

/**
 * @author huyuansong
 * @date 2021/5/18 17:03
 */
public class Demo01 {
    public static void main(String[] args) throws IOException {
        File file1 = new File("d:/1.txt");
        // 1 创建文件
        file1.createNewFile();
        File file2 = new File("d:/demo01");
        file2.mkdir();
        File file3 = new File("d:/demo01/demo02");
        file3.mkdirs();



    }

}
