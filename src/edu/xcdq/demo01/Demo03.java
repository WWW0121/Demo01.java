package edu.xcdq.demo01;

import java.io.*;

/**
 * @author huyuansong
 * @date 2021/5/18 17:53
 */
public class Demo03 {
    public static void main(String[] args) {
        BufferedInputStream bis = null;
        BufferedOutputStream bos = null ;
        try {
            // 1 准备输入输出流
            bis = new BufferedInputStream(new FileInputStream(new File("d:/jdk-15.0.2_windows-x64_bin.exe")));
            bos = new BufferedOutputStream(new FileOutputStream(new File("C:/jdk15.exe")));
            // 2 循环读取操作
            int len = 0 ;
            byte [] buff  = new byte[1024]; // 开辟缓冲区
            long start = System.currentTimeMillis(); // 开始计时
            while ((len = bis.read(buff)) != -1 ) {
                bos.write(buff , 0 ,len );
            }
            long end = System.currentTimeMillis(); // 结束计时
            System.out.println("时间" + (end - start ));  // 453 ms
            // 3 关闭输入输出资源
            bis.close();
            bos.close();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }
}
