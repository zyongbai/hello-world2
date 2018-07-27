package com.pingan.nio.server;

import java.util.Iterator;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;

public class NioClientService {
	private static final Integer SERVER_PORT = 8088;
	private static final String LOCALHOST = "127.0.0.1";
	
	private Selector selector = null;
	
	public void start() {
		try {
			SocketChannel socketChannel = SocketChannel.open();
			socketChannel.configureBlocking(false);
			socketChannel.connect(new InetSocketAddress(LOCALHOST, SERVER_PORT));
			selector = Selector.open();
			
			socketChannel.register(selector, SelectionKey.OP_CONNECT);
			
			run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void run() {
		while (true) {
			try {
				int num = selector.select();
				if (num == 0) continue;
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					if (key.isConnectable()) {
						SocketChannel socketChannel = (SocketChannel) key.channel();
						if (socketChannel.isConnectionPending()) {
							socketChannel.finishConnect();
						}
						
						socketChannel.configureBlocking(false);
						
						ByteBuffer writeBuf = ByteBuffer.allocate(1024);
						socketChannel.write(writeBuf.wrap("很无聊".getBytes("UTF-8")));
						
						socketChannel.register(selector, SelectionKey.OP_READ);
					}
					if (key.isReadable()) {
						handleRead(key);
					}
					
					iterator.remove();
				}
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
	
	private void handleRead(SelectionKey key) {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		ByteBuffer readBuf = ByteBuffer.allocate(1024);
		try {
			socketChannel.read(readBuf);
			String msg = new String(readBuf.array(), "UTF-8");
			System.out.println("服务器端来信:" + msg);
//			ByteBuffer writeBuf = ByteBuffer.allocate(1024);
//			socketChannel.write(writeBuf.wrap("不理你了".getBytes("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		NioClientService nioClientService = new NioClientService();
		nioClientService.start();
	}
}
