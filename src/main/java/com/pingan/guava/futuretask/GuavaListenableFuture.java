package com.pingan.guava.futuretask;

import java.io.IOException;
import java.util.concurrent.Callable;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeoutException;
import com.alibaba.dubbo.common.utils.NamedThreadFactory;
import com.alibaba.dubbo.common.concurrent.ListenableFutureTask;

public class GuavaListenableFuture {
	private static final ExecutorService executor = 
						new ThreadPoolExecutor(0, 10, 60L, TimeUnit.SECONDS, new SynchronousQueue<Runnable>(), new NamedThreadFactory("DubboMonitorCreator", true));
	
	public static void main(String[] args) throws InterruptedException, ExecutionException, IOException, TimeoutException {
		final ListenableFutureTask<Object> listenableFutureTask = ListenableFutureTask.create(new Callable<Object>() {
			@Override
			public Object call() throws Exception {
				System.out.println("·µ»ØNB");
				return "NB";
			}
		});
        listenableFutureTask.addListener(new Runnable() {
			@Override
			public void run() {
				try {
					Object call = listenableFutureTask.get();
					System.out.println("yongge:" + call);
				} catch (InterruptedException | ExecutionException e) {
					e.printStackTrace();
				}
			}
		});
        executor.execute(listenableFutureTask);
        
        System.out.println("result:" + listenableFutureTask.get(1, TimeUnit.MINUTES));
        
        System.in.read();
	}
}
