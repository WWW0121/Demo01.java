package edu.xcdq.demo05;

import java.io.*;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author wangwenbo
 * @data 2021/5/20 8:44
 */
// Properties 配置文件
public class Demo05 {
    public static void main(String[] args) throws IOException {
        Properties pro = new Properties();
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("a.properties"));
        pro.load(bis);
        bis.close();

       Set<Map.Entry<Object,Object>> entries = pro.entrySet();
     for (Map.Entry<Object,Object>e:entries){
           System.out.println(e.getKey()+":"+e.getValue());
       }


        BufferedOutputStream bos =  new BufferedOutputStream(new FileOutputStream("a.properties",false));
       pro.setProperty("habbit","resding");
       pro.store(bos,"添加了爱好");
       bos.close();
    }
}
