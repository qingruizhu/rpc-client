package com.ddup.rpc;
import java.lang.reflect.Proxy;
/**
 * 客户端：用以生成所要调用接口的代理类
 */
public class RpcProxyClient {

    public <T> T clientProxy(final Class<T> interfaceCls,String host,int port) {
            return (T)Proxy.newProxyInstance(interfaceCls.getClassLoader(), new Class<?>[]{interfaceCls}, new RemoteInvocationHandler(host,port));

    }
}
