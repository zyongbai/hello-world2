package com.pingan.event;

import java.util.EventListener;

public class StateChangeToOneListener implements EventListener {
	public void handleEvent(MyEvent event) {
		System.out.println("触发状态改变为1事件。。。");
		System.out.println("当前事件源状态为:" + event.getSourceState());
		System.out.println("。。。。。。。。。。");
	}
}
