package com.nott.nettychat.code.IOTest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.net.Socket;
import java.util.Date;

/**
 * @PackgeName: com.nott.nettychat.code.IOTest
 * @ClassName: IOClient
 * @Author: nott
 * Date: 2019/9/3 16:37
 * project name: nettychat
 * @Version:
 * @Description:
 */
public class IOClient {

    public static Logger log = LoggerFactory.getLogger(IOClient.class);

    public static void main(String[] args) {
        new Thread(() -> {
            try {
                Socket socket = new Socket("127.0.0.1", 8000);
                while (true) {
                    try {
                        socket.getOutputStream().write((new Date() + ": hello world").getBytes());
                        Thread.sleep(2000);
                    } catch (Exception e) {
                        log.info(e.getCause().getMessage());
                    }
                }
            } catch (IOException e) {
                log.info(e.getCause().getMessage());
            }
        }).start();
    }

}
