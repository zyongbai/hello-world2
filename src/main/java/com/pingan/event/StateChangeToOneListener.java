package com.pingan.event;

import java.util.EventListener;

public class StateChangeToOneListener implements EventListener {
	public void handleEvent(MyEvent event) {
		System.out.println("����״̬�ı�Ϊ1�¼�������");
		System.out.println("��ǰ�¼�Դ״̬Ϊ:" + event.getSourceState());
		System.out.println("��������������������");
	}
}
