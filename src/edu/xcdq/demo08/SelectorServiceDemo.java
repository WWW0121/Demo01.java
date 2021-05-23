package edu.xcdq.demo08;


import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * @author wangwenbo
 * @data 2021/5/20 11:17
 */
public class SelectorServiceDemo {
    public static void main(String[] args) throws IOException {
        int port = 8000;

        Selector selector = Selector.open();

        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();

        serverSocketChannel.configureBlocking(false);
        ServerSocket serverSocket = serverSocketChannel.socket();
        InetSocketAddress address = new InetSocketAddress(port);

        serverSocket.bind(address);

        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        System.out.println("服务器，端口："+port);

        ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
        while (true){
            if ((selector.select())>0){
                Set<SelectionKey>selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey>iter = selectionKeys.iterator();
                while (iter.hasNext()){
                    SelectionKey key = iter.next();
                    if (key.isAcceptable()){
                        acceptable(selector,byteBuffer,key);
                    }else if (key.isReadable()&& key.isValid()){
                        reabable(selector,byteBuffer,key);
                    }else if (key.isWritable() && key.isValid()){
                        writable(selector,byteBuffer,key);
                    }
                    
                    
                }
                //清除全部的key
                selectionKeys.clear();
                
            }
        }
                
    }

    private static void writable(Selector selector, ByteBuffer byteBuffer, SelectionKey key) throws IOException {
        SocketChannel client = (SocketChannel) key.channel();
        byteBuffer.clear();
        // 向缓冲区中设置内存
        byteBuffer.put(("欢迎进入NIO学习").getBytes());
        byteBuffer.flip();

        // 输入内容
        client.write(byteBuffer);
        client.register(selector,SelectionKey.OP_READ);

    }

    private static void reabable(Selector selector, ByteBuffer byteBuffer, SelectionKey key) throws IOException {

        SocketChannel client = (SocketChannel) key.channel();
        byteBuffer.clear();

        //读取内容到缓冲区
        int readSiza = client.read(byteBuffer);
        if (readSiza >0){
            System.out.println("服务器接受客服端数据"+new String(byteBuffer.array(),0,readSiza));
            client.register(selector,SelectionKey.OP_WRITE);
        }
    }

    private static void acceptable(Selector selector, ByteBuffer byteBuffer, SelectionKey key) throws IOException {
        ServerSocketChannel server = (ServerSocketChannel) key.channel();

        SocketChannel client = server.accept();

        client.write(byteBuffer);;
        client.register(selector,SelectionKey.OP_READ);

    }


}