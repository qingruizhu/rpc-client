package com.ddup.rpc;
/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        RpcProxyClient rpcProxyClient = new RpcProxyClient();
        IHelloSevice iHelloSevice = rpcProxyClient.clientProxy(IHelloSevice.class,"localhost",8080);
        String zqr = iHelloSevice.sayHello("zqr");
        System.out.println(zqr);
    }
}
