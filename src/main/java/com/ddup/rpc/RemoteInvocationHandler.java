package com.ddup.rpc;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * 执行真正方法的类，实现 InvocationHandler 接口
 */
public class RemoteInvocationHandler implements InvocationHandler {
    private String host;
    private int port;

    public RemoteInvocationHandler(String host, int port) {
        this.host = host;
        this.port = port;
    }

    /**
     * 代理方法
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("client come in invoking...");
        // 请求体
        RpcRequest request = new RpcRequest();
        request.setClassName(method.getDeclaringClass().getName());
        request.setMethodName(method.getName());
        request.setParameters(args);
        request.setVersion("v2.0");//调用 v2.0 版本
        // 发起网络传输
        RpcNetTransport rpcNetTransport = new RpcNetTransport(host, port);
        Object result = rpcNetTransport.send(request);
        return result;
    }
}
