package com.pingan.nio.server;

import java.util.Iterator;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.net.InetSocketAddress;
import java.nio.channels.Selector;
import java.nio.channels.SelectionKey;
import java.nio.channels.SocketChannel;
import java.nio.channels.ServerSocketChannel;

/**
 * 服务器端
 * @author ZHANGYONG415
 *
 */
public class NioServerService {
	private static final Integer SERVER_PORT = 8088;
	private static final String LOCALHOST = "127.0.0.1";
	
	private ServerSocketChannel serverSocketChannel = null;
	private Selector selector = null;
	
	public void start() {
		try {
			serverSocketChannel = ServerSocketChannel.open();
			serverSocketChannel.bind(new InetSocketAddress(LOCALHOST, SERVER_PORT));
			serverSocketChannel.configureBlocking(false);

			selector = Selector.open();
			
			serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
			
			// run
			run();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public void run() {
		while (true) {
			try {
				int num = selector.select();
				if (num == 0) continue;
				Iterator<SelectionKey> iterator = selector.selectedKeys().iterator();
				while (iterator.hasNext()) {
					SelectionKey key = iterator.next();
					if (key.isAcceptable()) {
						SocketChannel socketChannel = ((ServerSocketChannel) key.channel()).accept();
						socketChannel.configureBlocking(false);
						
						ByteBuffer writeBuf = ByteBuffer.allocate(1024);
						socketChannel.write(writeBuf.wrap("连我干啥".getBytes("UTF-8")));
						
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
			System.out.println("客户端来信:" + msg);
			ByteBuffer writeBuf = ByteBuffer.allocate(1024);
			socketChannel.write(writeBuf.wrap("小屁孩一边玩去!over".getBytes("UTF-8")));
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		NioServerService nioServerService = new NioServerService();
		nioServerService.start();
	}
	
}
