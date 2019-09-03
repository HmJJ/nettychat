package com.nott.nettychat.code.IOTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @PackgeName: com.nott.nettychat.code.IOTest
 * @ClassName: IOService
 * @Author: nott
 * Date: 2019/9/3 16:28
 * project name: nettychat
 * @Version:
 * @Description:
 */
public class IOServer {

    public static Logger log = LoggerFactory.getLogger(IOServer.class);

    public static void main(String[] args) throws Exception {

        ServerSocket serverSocket = new ServerSocket(8000);

        // 接收新连接线程
        new Thread(() -> {
            while (true) {
                try {
                    // 阻塞方法获取新的连接
                    Socket socket = serverSocket.accept();
                    // 每一个新的连接都创建一个线程，负责读取数据
                    new Thread(() -> {
                        try {
                            int len = 0;
                            byte[] data = new byte[1024];
                            InputStream inputStream = socket.getInputStream();
                            // 按字节流方式读取数据
                            while ((len = inputStream.read(data)) != -1) {
                                System.out.println(new String(data, 0, len));
                            }
                        } catch (IOException e) {
                            log.info(e.getCause().getMessage());
                        }
                    }).start();
                } catch (IOException e) {
                    log.info(e.getCause().getMessage());
                }
            }
        }).start();

    }

}
