package com.pingan.event;

import java.util.EventListener;

public class StateChangeListener implements EventListener {
	public void handleEvent(MyEvent event) {
		System.out.println("����״̬�ı��¼�������");
		System.out.println("��ǰ�¼�Դ״̬Ϊ:" + event.getSourceState());
		System.out.println("��������������������");
	}
}
