package edu.xcdq.demo07;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.StandardCharsets;

/**
 *@author   wangwenbo
 *@data     2021/5/20 10:30
 */
// NIO
public class Demo08 {
    public static void main(String[] args) throws FileNotFoundException {
        String info[] = {"欢迎","来到","喵星人","的星球","!!"};
        File file = new File("d:"+File.separator+"textfilechannel.text");

        try (FileOutputStream output = new FileOutputStream(file);
            FileChannel fout = output.getChannel(); ){

            ByteBuffer but = ByteBuffer.allocate(1024);
            for (int i = 0; i < info.length; i++) {
                // 字符串变为字节数组放入缓冲区之中
                but.put(info[i].getBytes());

            }
            but.flip();
            // 输出缓冲区的内容
            fout.write(but);
        } catch (IOException e) {
            e.printStackTrace();
        }


    }
}
