package com.ddup.rpc;

import com.ddup.rpc.conf.SpringConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        //RpcProxyClient rpcProxyClient = new RpcProxyClient();
        // 不再手动创建，从容器中获取
        AnnotationConfigApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfig.class);
        RpcProxyClient client = applicationContext.getBean(RpcProxyClient.class);
        IHelloSevice iHelloSevice = client.clientProxy(IHelloSevice.class,"localhost",8080);
        String zqr = iHelloSevice.sayHello("zqr");
        System.out.println(zqr);
    }
}


