package com.pingan.event;

import java.util.EventListener;
import java.util.HashSet;
import java.util.Set;

public class Source {
	private int flag = 0;
	Set<EventListener> listeners = new HashSet<EventListener>();
	
	public void addStateChangeListener(StateChangeListener listener) {
		listeners.add(listener);
	}
	
	public void addStateChangeToOneListener(StateChangeToOneListener listener) {
		listeners.add(listener);
	}
	
	public void notifyListener() {
		for (EventListener listener : listeners) {
			try {
				((StateChangeListener)listener).handleEvent(new MyEvent(this));
			} catch (Exception e) {
				if (flag == 1) {
					((StateChangeToOneListener)listener).handleEvent(new MyEvent(this));
				}
			}
		}
	}
	
	public void changeFlag() {
		flag = (flag == 0 ? 1 : 0);
		notifyListener();
	}
	
	public int getFlag() {
		return flag;
	}
}
