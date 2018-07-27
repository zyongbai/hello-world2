package com.pingan.proxy;

import com.pingan.proxy.dynastic.Go;
import com.pingan.proxy.dynastic.Hello;
import com.pingan.proxy.dynastic.ZyongProxy;

public class ProxyMain {
	public static void main(String[] args) {
		ZyongProxy proxy = new ZyongProxy();
		Hello hello = proxy.getProxy(new Class[]{Hello.class});
		hello.sayHello().sayHello();
		
		Go go = proxy.getProxy(new Class[]{Go.class});
		go.go().go();
	}
}
