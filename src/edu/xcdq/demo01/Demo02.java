package edu.xcdq.demo01;

import java.io.*;

/**
 * @author huyuansong
 * @date 2021/5/18 17:21
 */
// IO
public class Demo02 {
    public static void main(String[] args) {
        FileInputStream fis = null;
        FileOutputStream fos = null ;
        try {
            // 1 准备输入输出流
             fis = new FileInputStream(new File("d:/jdk-15.0.2_windows-x64_bin.exe"));
             fos = new FileOutputStream(new File("C:/jdk15.exe"));
            // 2 循环读取操作
            int len = 0 ;
            byte [] buff  = new byte[1024]; // 开辟缓冲区
            long start = System.currentTimeMillis();
            while ((len = fis.read(buff)) != -1 ) {
                fos.write(buff , 0 ,len );
            }
            long end = System.currentTimeMillis();
            System.out.println("时间"+ (end - start) );  // 1265
            // 3 关闭输入输出资源
            fis.close();
            fos.close();
        }catch (Exception e) {
            e.printStackTrace();
        }




    }
}
