package com.pingan.proxy.dynastic;

import java.lang.reflect.Proxy;
//import com.alibaba.dubbo.common.bytecode.Proxy;

public class ZyongProxy {
	public <T> T getProxy(Class<?>[] interfaces) {
//        return (T) Proxy.getProxy(interfaces).newInstance(new ZyongInvocation());
		return (T) Proxy.newProxyInstance(getClass().getClassLoader(), interfaces, new ZyongInvocation());
    }
}
