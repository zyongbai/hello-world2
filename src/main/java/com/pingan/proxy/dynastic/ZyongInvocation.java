package com.pingan.proxy.dynastic;

import java.lang.reflect.Method;
import java.lang.reflect.InvocationHandler;

public class ZyongInvocation implements InvocationHandler {

	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		System.out.println("proxy:" + proxy.getClass().getName());
		System.out.println("method:" + method);
		System.out.println("args:" + args);
		
		return proxy;
	}

}
